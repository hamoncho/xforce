/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.db;

import com.xforce.model.User;
import com.xforce.model.UserType;
import com.xforce.utils.Validate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Hamoncho
 */
public class MySQL implements DataBase {

    protected Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/xforce";
    private static final String USER = "hamoncho";
    private static final String CLAVE = "hamoncho";

    protected Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }

    @Override
    public UserType logIn(User user) {
        PreparedStatement ps;
        ResultSet rs;

        String query = "INSERT INTO `admn_gym`.`usuarios` (`username`, `email`, `telefono`, `contrasenna`, `tipo_Usuario`) VALUES (?, ?, ?, ?, ?);";

        try {
            ps = getConnection().prepareStatement(query);

            ps.setString(1, "hams");
            ps.setString(2, "hams@gmail.com");
            ps.setString(3, "4521353535");
            ps.setString(4, "contra");
            ps.setInt(5, 3);

            rs = ps.executeQuery();

//            if (rs.next()) {
//                System.out.println(rs.getArray(2).toString());
//            } else {
//
//            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public void signIn(User user) {
        
        if(user == null){
            throw new  IllegalArgumentException();
        }
        if(Validate.isPassword(user.password())){
            throw  new IllegalArgumentException();
        }
        if(user.email().matches("[A-Z][a-zA-Z]*")){
            throw  new IllegalArgumentException();
        }
        
        PreparedStatement ps;
        ResultSet rs;

        String query = "INSERT INTO `admn_gym`.`usuarios` (`username`, `email`, `telefono`, `contrasenna`, `tipo_Usuario`) VALUES (?, ?, ?, ?, ?);";

        try {
            
            ps = getConnection().prepareStatement(query);

            ps.setString(1, user.userName());
            ps.setString(2, user.email());
            ps.setString(3, user.phone());
            ps.setString(4, user.password());
            ps.setInt(5, 3);

            ps.execute();

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Error");
            a.setContentText("Usuario Agregado con exito : " + user.userName());
            a.show();
            
//            if (rs.next()) {
//                System.out.println(rs.getArray(2).toString());
//            } else {
//
//            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
