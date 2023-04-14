/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import com.xforce.view.ViewManager;
import com.xforce.view.Views;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane anchorPaneAreas;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void OnMouseCardiovascularArea(MouseEvent event) {
        try {
            anchorPaneAreas.getChildren().setAll(ViewManager.loadFXML(Views.CARDIOVASCULAR_AREA.getUrl()));
        } catch (IOException ex) {
            Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OnMouseClickedFunctionalFitnessArea(MouseEvent event) {
        try {
            anchorPaneAreas.getChildren().setAll(ViewManager.loadFXML(Views.FUNCTIONAL_FITNESS_AAREA.getUrl()));
        } catch (IOException ex) {
            Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void OnMouseClikedFreeWeightsArea(MouseEvent event) {
        try {
            anchorPaneAreas.getChildren().setAll(ViewManager.loadFXML(Views.FREE_WEIGHTS_AREA.getUrl()));
        } catch (IOException ex) {
            Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void OnMouseClikedStretchingAndMobilityArea(MouseEvent event) {
        try {
            anchorPaneAreas.getChildren().setAll(ViewManager.loadFXML(Views.STRETCHING_AND_MOBILITY_AREA.getUrl()));
        } catch (IOException ex) {
            Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void OnMouseClikedPersonalTrainingCorners(MouseEvent event) {
        try {
            anchorPaneAreas.getChildren().setAll(ViewManager.loadFXML(Views.PERSONAL_TRAINING_CORNERS_AREA.getUrl()));
        } catch (IOException ex) {
            Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
