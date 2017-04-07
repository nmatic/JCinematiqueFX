package ca.qc.nmatic.cinematique.JCinematiqueFX;

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
    XYChart.Series series = new XYChart.Series();

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
    private LineChart<Number, Number> graphChart = new LineChart<>(xAxis, yAxis);

    ;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Kinetics kinetics = new Kinetics(entryInitialPos.getText(), entryFinalPos.getText(), entryInitialVel.getText(), entryFinalVel.getText(), entryElapsedTime.getText(), entryAcceleration.getText(), (String) desiredValue.getValue());
        System.out.println(kinetics.findValue());
        outputField.setText(kinetics.findValue());
        fillChartWithXSquared();
        graphChart.getData().add(series);
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
    }

    @FXML
    public void resetButton() {
        resetFields();
//        showFields();
    }

    @FXML
    private void showFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void fillChartWithXSquared() {
        for (int i = 1; i < 30; i++) {
            series.getData().add(new XYChart.Data(i, (i * i)));
        }

    }

    private int desiredId(String value) {
        switch (value) {
            case "Initial position":
                return 1;
            case "Final position":
                return 2;
            case "Initial velocity":
                return 3;
            case "Final velocity":
                return 4;
            case "Elapsed time":
                return 5;
            case "Acceleration":
                return 6;
            default:
                return 0;
        }
    }
//    @FXML
//    public void hideUnused(String valeurRecherche) {
//        showFields();
//        switch(valeurRecherche){
//            case 1:
////                labelInitialPos.setVisible(false);
//                entryInitialPos.setEditable(false);
//                break;
//            case 2:
////                labelFinalPos.setVisible(false);
//                valeurXf.setVisible(false);
//                break;
//            case 3:
////                labelInitialVel.setVisible(false);
//                valeurVi.setVisible(false);    
//		break;
//            case 4:
////                labelFinalVel.setVisible(false);
//                valeurVf.setVisible(false);   
//                break;
//            case 5:
////                labelElapsedTime.setVisible(false);
//                valeurDt.setVisible(false);    
//                break;
//            case 6:
////                labelAcceleration.setVisible(false);
//                valeurA.setVisible(false);  
//                break;
//        }
//    }                  
//    public void menuResetActionPerformed() {                                          
//        resetButton();
//    }                                         
//
//    public void menuQuitterActionPerformed() {                                            
//        System.exit(0);
//    }                                           
//
//    public void menuCommentActionPerformed() {                                            
//        JOptionPane.showMessageDialog(new JFrame(), "1. Choisir la donnée recherchée." + "\n 2. Entrer seulement les valeurs connues." + "\n 3. Appuyer sur le bouton \"Calculer\".", "Aide", JOptionPane.PLAIN_MESSAGE);
//    }                                           
//
//    public void menuAboutActionPerformed() {                                          
//        JOptionPane.showMessageDialog(new JFrame(), "(c)2016 Victor Babin" + "\n Calculateur de la cinématique en Java" + "\n https://github.com/vicbab ", "À propos", JOptionPane.PLAIN_MESSAGE);
//    }     

}
