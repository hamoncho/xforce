/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import com.xforce.db.MySQL;
import com.xforce.model.User;
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
        final var userName = textFieldUserName.getText();
        final var password = passwordField.getText();
        final var passwordRepeat = passwordFieldRepeat.getText();
        final var email = textFieldEmail.getText();
        final var phone = textFieldPhone.getText();

        try {
            if (!password.equals(passwordRepeat)) {
                throw new IllegalArgumentException("passwords are different");
            }

            User user = new User();

            user.setUsername(userName);
            user.setContrasenna(password);
            user.setEmail(email);
            user.setTelefono(phone);

            MySQL mysql = new MySQL();
            mysql.signIn(user);

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Sign up");
            a.setContentText("user " + user.getUsername() + "add to database");
            a.showAndWait();

	    ViewManager.go(Views.LOGIN); 	//go to login after sign in.

        } catch (IllegalArgumentException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Illegal Argument");
            a.setContentText(e.getMessage());
            a.show();
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText(ex.getMessage());
            a.show();
        }
    }

}
