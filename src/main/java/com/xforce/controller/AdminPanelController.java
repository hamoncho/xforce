/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Hamoncho
 */
public class AdminPanelController implements Initializable {

    @FXML
    private VBox vBoxContainer;
    @FXML
    private TextField textFieldApellidos;
    @FXML
    private TextField textFieldNumTarjeta;
    @FXML
    private TextField textFieldNacimiento;
    @FXML
    private TextField textFieldTipoSangineo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnActionEliminar(ActionEvent event) {
    }

    @FXML
    private void OnActionAdmin(ActionEvent event) {
    }

    @FXML
    private void OnActionCliente(ActionEvent event) {
        HBox aux = new HBox(new Label("hola"));
        vBoxContainer.getChildren().add(aux);
    }
    
}
