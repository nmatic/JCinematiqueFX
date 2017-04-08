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
    private Label labelInitialPos;
    @FXML
    private Label labelFinalPos;
    @FXML
    private Label labelInitialVel;
    @FXML
    private Label labelFinalVel;
    @FXML
    private Label labelElapsedTime;
    @FXML
    private Label labelAcceleration;
    @FXML
    private TextArea outputField;
    @FXML
    private ComboBox desiredValue;
    @FXML
    private LineChart<Number, Number> posGraph = new LineChart<>(xAxis, yAxis);

    ;
    private int nbSeries = 1;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Kinetics kinetics = new Kinetics(entryInitialPos.getText(), entryFinalPos.getText(), entryInitialVel.getText(), entryFinalVel.getText(), entryElapsedTime.getText(), entryAcceleration.getText(), (String) desiredValue.getValue());
        outputField.setText(kinetics.findValue());
        try {
            fillPositionChart(kinetics, "Series " + nbSeries);
            posGraph.getData().add(fillPositionChart(kinetics, "Series " + nbSeries));
            nbSeries++;
        } catch (Exception e) {

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
        posGraph.getData().clear();
        nbSeries = 0;
    }

    @FXML
    public void resetButton() {
        resetFields();
    }

    private XYChart.Series fillPositionChart(Kinetics obj, String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);
        double INTERVAL = obj.getElapsedTime();
        Keyframe posKeyframe = new PositionKeyframe(0, INTERVAL, 2.5);
        for (int i = 0; i < INTERVAL; i++) {
            posKeyframe.setTime(i);
            
            series.getData().add(new XYChart.Data(i, posKeyframe.posValue(i, obj)));
        }
        return series;
    }
}
