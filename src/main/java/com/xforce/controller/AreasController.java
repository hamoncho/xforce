/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hamoncho
 */
public class AreasController implements Initializable {

    @FXML
    private VBox VBoxCardiovascularArea;
    @FXML
    private VBox VBoxFunctionalFitnessArea;
    @FXML
    private VBox VBoxStretchingAndMobilityArea;
    @FXML
    private VBox VBoxPersonalTrainingCorners;
    @FXML
    private VBox VBoxFreeWeightsArea;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnMouseCardiovascularArea(MouseEvent event) {
    }

    @FXML
    private void OnMouseClickedFunctionalFitnessArea(MouseEvent event) {
    }

    @FXML
    private void OnMouseClikedFreeWeightsArea(MouseEvent event) {
    }

    @FXML
    private void OnMouseClikedStretchingAndMobilityArea(MouseEvent event) {
    }

    @FXML
    private void OnMouseClikedPersonalTrainingCorners(MouseEvent event) {
    }
    
}
