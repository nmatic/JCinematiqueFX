/*
 * Copyright (C) 2017 Victor Babin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.qc.nmatic.cinematique.UI;

import ca.qc.nmatic.cinematique.JCinematiqueFX.*;
import ca.qc.nmatic.cinematique.Keyframes.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Babin
 */
public class JCinematiqueFXUIController implements Initializable {

    ObservableList<String> chosenValue = FXCollections.observableArrayList("- SELECT -", "Initial position", "Final position", "Initial velocity", "Final velocity", "Elapsed time", "Acceleration");

    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    @FXML
    private TextField entryInitialPos;
    @FXML
    private TextField entryFinalPos;
    @FXML
    private TextField entryInitialVel;
    @FXML
    private TextField entryFinalVel;
    @FXML
    private TextField entryElapsedTime;
    @FXML
    private TextField entryAcceleration;
    @FXML
    private TextArea outputField;
    @FXML
    private ComboBox desiredValue;
    @FXML
    private LineChart<Number, Number> posGraph = new LineChart<>(xAxis, yAxis);
    @FXML
    private LineChart<Number, Number> velGraph = new LineChart<>(xAxis, yAxis);
    @FXML
    private LineChart<Number, Number> accGraph = new LineChart<>(xAxis, yAxis);
    @FXML
    private WebView latexOut = new WebView();
    private int nbSeries = 1;
    private Formulas formula = new Formulas();

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Kinetics kinetics = new Kinetics(entryInitialPos.getText(), entryFinalPos.getText(), entryInitialVel.getText(), entryFinalVel.getText(), entryElapsedTime.getText(), entryAcceleration.getText(), (String) desiredValue.getValue());
        outputField.setText(kinetics.findValue());
        WebEngine webEngine = latexOut.getEngine();
        webEngine.load(writeLatexFormula(kinetics.getLatex()).toURI().toURL().toExternalForm());
        if (kinetics.isWithoutError()) {
            posGraph.getData().add(fillPositionChart(kinetics, "Series " + nbSeries));
            velGraph.getData().add(fillVelocityChart(kinetics, "Series " + nbSeries));
            accGraph.getData().add(fillAccelerationChart(kinetics, "Series " + nbSeries));
            nbSeries++;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        desiredValue.setValue("- SELECT -");
        desiredValue.setItems(chosenValue);
    }

    @FXML
    public void resetFields() {
        entryAcceleration.setText("");
        entryElapsedTime.setText("");
        entryFinalPos.setText("");
        entryFinalVel.setText("");
        entryInitialPos.setText("");
        entryInitialVel.setText("");
        desiredValue.setValue("- SELECT -");
        desiredValue.setItems(chosenValue);
    }

    @FXML
    public void resetButton() {
        resetFields();
        resetCharts();
    }

    @FXML
    public void resetCharts() {
        posGraph.getData().clear();
        velGraph.getData().clear();
        accGraph.getData().clear();
        nbSeries = 0;
    }

    private XYChart.Series fillPositionChart(Kinetics obj, String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        double INTERVAL = obj.getElapsedTime();
        Keyframe posKeyframe = new Keyframe(0, INTERVAL, 2.5);
        for (int i = 0; i <= INTERVAL; i++) {
            posKeyframe.setTime(i);

            series.getData().add(new XYChart.Data(i, posKeyframe.posValue(i, obj)));
        }
        return series;
    }

    private XYChart.Series fillAccelerationChart(Kinetics obj, String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        double INTERVAL = obj.getElapsedTime();
        Keyframe accKeyframe = new Keyframe(0, INTERVAL, 2.5);
        for (int i = 0; i <= INTERVAL; i++) {
            accKeyframe.setTime(i);
            series.getData().add(new XYChart.Data(i, accKeyframe.accValue(i, obj)));
        }
        return series;
    }

    private XYChart.Series fillVelocityChart(Kinetics obj, String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        double INTERVAL = obj.getElapsedTime();
        Keyframe velKeyframe = new Keyframe(0, INTERVAL, 2.5);
        for (int i = 0; i <= INTERVAL; i++) {
            velKeyframe.setTime(i);

            series.getData().add(new XYChart.Data(i, velKeyframe.velValue(i, obj)));
        }
        return series;
    }

    public File writeLatexFormula(String latexFormula) throws IOException {
        File f = new File("current_equation.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html>\n");
        bw.write("<head>\n");
        bw.write("<title>LaTeX</title>\n");
        bw.write("<meta charset=\"UTF-8\">\n");
        bw.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        bw.write("<script type=\"text/x-mathjax-config\">MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}});</script>\n");
        bw.write("<script type=\"text/javascript\" async\n");
        bw.write("src=\"https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.0/MathJax.js?config=TeX-MML-AM_CHTML\">\n");
        bw.write("</script>\n");
        bw.write("</head>\n");
        bw.write("<body>\n");
        bw.write("<p>\n$" + latexFormula + "$\n</p>\n");
        bw.write("</body>\n");
        bw.write("</html>\n");
        bw.close();
        return f;
    }
//    public void Browser() {
//        //apply the styles
//        getStyleClass().add("browser");
//        // load the web page
//        webEngine.load("http://www.oracle.com/products/index.html");
//        //add the web view to the scene
//        getChildren().add(browser);
//
//    }
}
