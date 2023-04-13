/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import com.xforce.db.MySQL;
import com.xforce.model.User;
import com.xforce.model.UserType;
import com.xforce.utils.Validate;
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
        final String userName;
        final String password;
        final String email;
        final String phone;

        try {
            
            if(!Validate.isName(textFieldUserName.getText())){
                throw new IllegalArgumentException("not a valid name");
            }
            if(!Validate.isPassword(passwordField.getText())){
                throw new IllegalArgumentException("not a valid password");
            }
            if(!Validate.isEmail(textFieldEmail.getText())){
                throw new IllegalArgumentException("not a valid E-mail");
            }
            if(!Validate.isPhone(textFieldPhone.getText())){
                throw new IllegalArgumentException("not a valid number phone");
            }
            
            if(!passwordField.equals(passwordFieldRepeat)){
                throw new IllegalArgumentException("passwords are different");
            }
            
            userName = textFieldUserName.getText();
            password = passwordField.getText();
            email = textFieldEmail.getText();
            phone = textFieldPhone.getText();
            
           User user = new User();
           
           user.setUsername(userName);
           user.setContrasenna(password);
           user.setEmail(email);
           user.setTelefono(phone);
           
            MySQL mysql = new MySQL();
            mysql.signIn(user);

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Sign up");
            a.setContentText("Usuario Agregado con exito : " + user.getUsername());
            a.show();
            
        } catch (IllegalArgumentException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.show();
        }

        //ViewManager.go(Views.LOGIN);
    }

}
