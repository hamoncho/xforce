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
import java.util.Optional;
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
    public Optional<? extends User> logIn(String password, String username) {
        Optional<User> al = Optional.of(new User());
        return al;
    }

    public void signIn(User user) {
        
        if(user == null){
            throw new  IllegalArgumentException();
        }
        
        
        PreparedStatement ps;
        ResultSet rs;

        String query = "INSERT INTO `xforce`.`usuarios` (`username`, `email`, `telefono`, `contrasenna`, `tipo_Usuario`) VALUES (?, ?, ?, ?, ?);";

        try {
            
            ps = getConnection().prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getTelefono());
            ps.setString(4, user.getContrasenna());
            ps.setInt(5, 3);

            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
