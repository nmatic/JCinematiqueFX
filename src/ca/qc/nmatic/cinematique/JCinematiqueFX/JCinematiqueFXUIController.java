/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.nmatic.cinematique.JCinematiqueFX;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

/**
 *
 * @author Administrateur
 */
public class JCinematiqueFXUIController implements Initializable {
    
    ObservableList<String> = FXCollections.observableArrayList("Initial position", "Final position", "Initial velocity", "Final velocity", "Elapsed time", "Acceleration");
    
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
    private void handleButtonAction(ActionEvent event) {
        Kinetics kinetics = new Kinetics(entryInitialPos.getText(), entryFinalPos.getText(), entryInitialVel.getText(), entryFinalVel.getText(), entryElapsedTime.getText(), entryAcceleration.getText(), 0);
        outputField.setText(kinetics.findValue());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void resetFields(){
        entryAcceleration.setText("");
        entryElapsedTime.setText("");
        entryFinalPos.setText("");
        entryFinalVel.setText("");
        entryInitialPos.setText("");
        entryInitialVel.setText("");
    }
    
    @FXML
    public void resetButton(){
        resetFields();
        showFields();
    }
    
    @FXML
    private void showFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    @FXML
//    public void hideUnused() {                                             
//        valeurRecherche = valRecherche.getSelectedIndex();
//        showFields();
//        switch(valeurRecherche){
//            case 1:
//                labelXi.setVisible(false);
//                valeurXi.setVisible(false);
//                break;
//            case 2:
//                labelXf.setVisible(false);
//                valeurXf.setVisible(false);
//                break;
//            case 3:
//                labelVi.setVisible(false);
//                valeurVi.setVisible(false);    
//		break;
//            case 4:
//                labelVf.setVisible(false);
//                valeurVf.setVisible(false);   
//                break;
//            case 5:
//                labelDt.setVisible(false);
//                valeurDt.setVisible(false);    
//                break;
//            case 6:
//                labelA.setVisible(false);
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
