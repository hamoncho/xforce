/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.xforce.controller;

import com.xforce.App;
import com.xforce.db.MySQL;
import com.xforce.model.Admin;
import com.xforce.model.Cliente;
import com.xforce.model.User;
import static com.xforce.view.ViewManager.go;
import static com.xforce.view.Views.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private TextField textFieldNombre;
    @FXML
    private Label labelSelected;

    private User userSelected;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vBoxContainer.getChildren().addAll(getAllHBoxItemsUsuario());
    }

    @FXML
    private void OnActionEliminar(ActionEvent event) {
        MySQL sql = new MySQL();
        sql.deleteUser(userSelected.getId_Usuario());
        go(PANEL_ADMIN);

    }

    @FXML
    private void OnActionAdmin(ActionEvent event) {
        Admin a = new Admin();
        MySQL sql = new MySQL();
        a.setId_Usuario(userSelected.getId_Usuario());
        a.setContrasenna(userSelected.getContrasenna());
        a.setEmail(userSelected.getEmail());
        a.setFechaRegistro(userSelected.getFechaRegistro());
        a.setTelefono(userSelected.getTelefono());
        a.setTipo_Usuario(1);
        a.setUsername(userSelected.getUsername());

        a.setNombre(textFieldNombre.getText());
        a.setApellido(textFieldApellidos.getText());

        try {
            if (userSelected.getTipo_Usuario() == 0) {
                throw new IllegalArgumentException("Ya es un admin");
            }
            sql.becomeAdmin(userSelected, a);
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Ya Eres Admin");
            alert.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        go(PANEL_ADMIN);
    }

    @FXML
    private void OnActionCliente(ActionEvent event) {
        MySQL sql = new MySQL();
        Cliente c = new Cliente();
        c.setId_Usuario(userSelected.getId_Usuario());
        c.setContrasenna(userSelected.getContrasenna());
        c.setEmail(userSelected.getEmail());
        c.setFechaRegistro(userSelected.getFechaRegistro());
        c.setTelefono(userSelected.getTelefono());
        c.setTipo_Usuario(1);
        c.setUsername(userSelected.getUsername());

        c.setNombre(textFieldNombre.getText());
        c.setApellido(textFieldApellidos.getText());
        c.setNum_targeta(textFieldNumTarjeta.getText());
        c.setFecha_nacimiento(LocalDate.now());
        c.setFecha_targeta(LocalDate.now());
        c.setTipo_sanguineo("O+");
        System.out.println(c.toString());

        try {
            if (userSelected.getTipo_Usuario() == 1) {
                throw new IllegalArgumentException("Ya es un Cliente");
            }
            sql.becomeCliente(userSelected, c);
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Ya Eres Cliente");
            alert.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(AdminPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        go(PANEL_ADMIN);
    }

    private ArrayList<HBox> getAllHBoxItemsUsuario() {
        ArrayList<HBox> listHbox = new ArrayList<>();
        MySQL mysql = new MySQL();
        mysql.getAllUser().forEach(user -> listHbox.add(getHBoxItemUsuario(user)));
        return listHbox;
    }

    private HBox getHBoxItemUsuario(User user) {
        HBox userItem = new HBox();
        VBox columnOne = new VBox();
        VBox columnTwo = new VBox();

        Image image = new Image(getClass().getResourceAsStream("/com/xforce/view/img/coach.png"));
        ImageView imgPerfil = new ImageView(image);
        imgPerfil.setFitWidth(75);
        imgPerfil.setFitHeight(75);

        userItem.getChildren().add(imgPerfil);

        columnOne.getChildren().add(new Label("ID: " + String.valueOf(user.getId_Usuario())));
        columnOne.getChildren().add(new Label("User Name: " + user.getUsername()));
        columnOne.getChildren().add(new Label("Password: " + user.getContrasenna()));

        columnTwo.getChildren().add(new Label("   User Type: " + String.valueOf(user.getTipo_Usuario())));
        columnTwo.getChildren().add(new Label("   Email: " + user.getEmail()));
        columnTwo.getChildren().add(new Label("   Phone: " + user.getTelefono()));

        userItem.getChildren().add(columnOne);
        userItem.getChildren().add(columnTwo);

        userItem.getStyleClass().add("itemUsuario");
        userItem.setOnMouseClicked((t) -> {

            vBoxContainer.getChildren().forEach(node -> {
                if (node.getStyleClass().contains("itemSelected")) {
                    node.getStyleClass().remove("itemSelected");
                } else {

                }
            });
            userItem.getStyleClass().add("itemSelected");
            userSelected = user;
            labelSelected.setText("ID: " + userSelected.getId_Usuario() + "   User: " + userSelected.getUsername() + " Tipo: " + userSelected.getTipo_Usuario());

        });

        return userItem;
    }
}
