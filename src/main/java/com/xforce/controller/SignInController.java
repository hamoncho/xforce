/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import com.xforce.db.MySQL;
import com.xforce.model.User;
import com.xforce.model.UserType;
import com.xforce.view.ViewManager;
import com.xforce.view.Views;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hamoncho
 */
public class SignInController implements Initializable {

    @FXML
    private TextField textFieldName;
    private TextField textFieldLastNames;
    @FXML
    private TextField textFieldPhone;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldUserName;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordFieldRepeat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void OnActionCreateAccount(ActionEvent event) {
        String userName;
        String password;
        String email;
        String phone;

        try {
            
            if(textFieldUserName.getText().isBlank()){
                throw new IllegalArgumentException("is Blank");
            }
            if(passwordField.getText().isBlank()){
                throw new IllegalArgumentException("is Blank");
            }
            if(textFieldEmail.getText().isBlank()){
                throw new IllegalArgumentException("is Blank");
            }
            if(textFieldName.getText().isBlank()){
                throw new IllegalArgumentException("is Blank");
            }
            if(textFieldLastNames.getText().isBlank()){
                throw new IllegalArgumentException("is Blank");
            }
            if(textFieldPhone.getText().isBlank()){
                throw new IllegalArgumentException("is Blank");
            }
            
            userName = textFieldUserName.getText();
            password = passwordField.getText();
            email = textFieldEmail.getText();
            phone = textFieldPhone.getText();
            
           User user = new User();
           
           user.setUsername(userName);
           user.setContrasenna(password);
           user.setEmail(email);
           
            MySQL mysql = new MySQL();
            mysql.signIn(user);

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Sign up");
            a.setContentText("Usuario Agregado con exito : " + user.getUsername());
            a.show();
            
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.show();
        }

        //ViewManager.go(Views.LOGIN);
    }

}
