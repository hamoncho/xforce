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
    }

    @FXML
    private void OnMouseCardiovascularArea(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY -> {
                try {
                    CustomerDashboardController.getSIGLETON()
                            .getBorderPane()
                            .setCenter(ViewManager
                                    .loadFXML(Views.CARDIOVASCULAR_AREA.getUrl()));
                } catch (IOException ex) {
                    Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            case BACK -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case FORWARD -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case MIDDLE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case NONE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case SECONDARY -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
        }

    }

    @FXML
    private void OnMouseClickedFunctionalFitnessArea(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY -> {
                try {
                    CustomerDashboardController.getSIGLETON()
                            .getBorderPane()
                            .setCenter(ViewManager
                                    .loadFXML(Views.FUNCTIONAL_FITNESS_AAREA.getUrl()));
                } catch (IOException ex) {
                    Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            case BACK -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case FORWARD -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case MIDDLE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case NONE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case SECONDARY -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
        }

    }

    @FXML
    private void OnMouseClikedFreeWeightsArea(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY -> {
                try {
                    CustomerDashboardController.getSIGLETON()
                            .getBorderPane()
                            .setCenter(ViewManager
                                    .loadFXML(Views.FREE_WEIGHTS_AREA.getUrl()));
                } catch (IOException ex) {
                    Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            case BACK -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case FORWARD -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case MIDDLE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case NONE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case SECONDARY -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
        }

    }

    @FXML
    private void OnMouseClikedStretchingAndMobilityArea(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY -> {
                try {
                    CustomerDashboardController.getSIGLETON()
                            .getBorderPane()
                            .setCenter(ViewManager
                                    .loadFXML(Views.STRETCHING_AND_MOBILITY_AREA
                                            .getUrl()));
                } catch (IOException ex) {
                    Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            case BACK -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case FORWARD -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case MIDDLE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case NONE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case SECONDARY -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
        }

    }

    @FXML
    private void OnMouseClikedPersonalTrainingCorners(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY -> {
                try {
                    CustomerDashboardController.getSIGLETON()
                            .getBorderPane()
                            .setCenter(ViewManager
                                    .loadFXML(Views.PERSONAL_TRAINING_CORNERS_AREA
                                            .getUrl()));
                } catch (IOException ex) {
                    Logger.getLogger(AreasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            case BACK -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case FORWARD -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case MIDDLE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case NONE -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            case SECONDARY -> throw new UnsupportedOperationException("Unimplemented case: " + event.getButton());
            default -> throw new IllegalArgumentException("Unexpected value: " + event.getButton());
        }

    }

}
