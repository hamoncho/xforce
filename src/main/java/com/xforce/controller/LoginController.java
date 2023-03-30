/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import com.xforce.view.ViewManager;
import com.xforce.view.Views;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hamoncho
 */
public class LoginController implements Initializable {

    @FXML
    private TextField textFieldUser;
    @FXML
    private PasswordField passwordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnActionLogin(ActionEvent event) {
        ViewManager.go(Views.CUSTOMER_DASHBOARD);
    }

    @FXML
    private void onActionExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void onActionSingIn(ActionEvent event) {
        ViewManager.go(Views.SING_IN);
    }
    
}
