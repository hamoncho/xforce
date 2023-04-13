/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.db;

import com.xforce.model.Admin;
import com.xforce.model.Cliente;
import com.xforce.model.Instructor;
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

    @Override
    public void signIn(User user) throws Exception, IllegalArgumentException {

        if (user == null) {
            throw new IllegalArgumentException("user is null");
        }

        if (!Validate.isName(user.getUsername())) {
            throw new IllegalArgumentException("not a valid name");
        }

        if (!Validate.isEmail(user.getEmail())) {
            throw new IllegalArgumentException("not a valid E-mail");
        }

        if (!Validate.isPhone(user.getTelefono())) {
            throw new IllegalArgumentException("not a valid number phone");
        }

        if (!Validate.isPassword(user.getContrasenna())) {
            throw new IllegalArgumentException("not a valid password");
        }

        addUser(user);

    }

  

    @Override
    public void addUser(User user) throws Exception{
        PreparedStatement ps;
        ResultSet rs;

        var query = "INSERT INTO xforce.usuario"
                + "(username, email, telefono, contrasenna) "
                + "VALUES(?, ?, ?, ?);";

        try (var con = getConnection()) {

            ps = con.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getTelefono());
            ps.setString(4, user.getContrasenna());

            ps.execute();

        }  catch (SQLException ex) {
            throw  new Exception("SQLException: "+ ex.getMessage());
        } finally {

        }
        
    }

    @Override
    public boolean userNameExists(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean emailExists(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Integer> getIdUsuario(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean userExists(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean adminExists(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean clienteExists(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean instructorExists(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void becomeAdmin(User current, Admin target) throws Exception, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void becomeCliente(User current, Cliente target) throws Exception, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void becomeInstructor(User current, Instructor target) throws Exception, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void becomeUsuario(User user) throws Exception, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<? extends User> getUser(int id) throws Exception, IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateUser(int id, User userUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
