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
    public Optional<? extends User> logIn(String password, String username)
            throws Exception {

        PreparedStatement ps;
        ResultSet rs;

        try ( var con = getConnection()) {
            var query = "SELECT * FROM usuario WHERE username = ?"
                    + " and contrasenna = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();

                user.setId_Usuario(rs.getInt("id_Usuario"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setTelefono(rs.getString("telefono"));
                user.setContrasenna(rs.getString("contrasenna"));
                user.setTipo_Usuario(rs.getInt("tipo_Usuario"));

                return Optional.of(user);

            }

        } catch (SQLException ex) {
            return Optional.empty();
        }

        return Optional.empty();
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
    public void addUser(User user) throws Exception {
        PreparedStatement ps;
        ResultSet rs;

        var query = "INSERT INTO xforce.usuario"
                + "(username, email, telefono, contrasenna) "
                + "VALUES(?, ?, ?, ?);";

        try ( var con = getConnection()) {

            ps = con.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getTelefono());
            ps.setString(4, user.getContrasenna());

            ps.execute();

        } catch (SQLException ex) {
            throw new Exception("SQLException: " + ex.getMessage());
        } finally {

        }

    }

    @Override
    public boolean userNameExists(String userName) throws Exception {
        PreparedStatement ps;
        ResultSet rs;

        var query = "SELECT username FROM usuario WHERE username = ?;";

        try ( var con = getConnection()) {
            ps = con.prepareStatement(query);

            ps.setString(1, userName);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;

            } else {
                return false;

            }

        } catch (SQLException ex) {
            throw new Exception("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean emailExists(String email) throws Exception {
        PreparedStatement ps;
        ResultSet rs;

        var query = "SELECT email FROM usuario WHERE email = ?;";

        try ( var con = getConnection()) {
            ps = con.prepareStatement(query);

            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;

            } else {
                return false;

            }

        } catch (SQLException ex) {
            throw new Exception("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Optional<Integer> getIdUsuario(String username, String password)
            throws Exception {

        PreparedStatement ps;
        ResultSet rs;

        var query = "SELECT id_Usuario FROM usuario"
                + " WHERE username = ? and contrasenna = ?";

        try ( var con = getConnection()) {
            ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                return Optional.of(rs.getInt("id_Usuario"));

            } else {
                return Optional.empty();

            }

        } catch (SQLException ex) {
            throw new Exception("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public boolean userExists(User user) {
        return userExtendsExists(user, "usuario");
    }

    @Override
    public boolean adminExists(Admin admin) {
        if (userExtendsExists(admin, "admin")) {
            PreparedStatement ps;
            ResultSet rs;

            try ( var con = getConnection()) {
                var query = "SELECT nombre FROM admin WHERE Nombre = ? and"
                        + " Apellido = ?"
                        + " and id_Usuario = ?"
                        + " and tipo_Usuario = ?";

                ps = con.prepareStatement(query);

                ps.setString(1, admin.getNombre());
                ps.setString(2, admin.getApellido());
                ps.setString(3, "" + admin.getId_Usuario());
                ps.setString(4, "" + admin.getTipo_Usuario());

                rs = ps.executeQuery();

                if (rs.next()) {
                    return true;

                }

            } catch (SQLException ex) {
                return false;
            }

        }

        return false;
    }

    public boolean userExtendsExists(User user, String tabla) {
        ResultSet rs;
        PreparedStatement ps;

        try ( var con = getConnection()) {
            var query = "SELECT * FROM ? WHERE id_Usuario = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, tabla);
            ps.setString(2, "" + user.getId_Usuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                if (user.getUsername().equals(rs.getString("username"))
                        && user.getEmail().equals(rs.getString("email"))
                        && user.getTelefono().equals(rs.getString("telefono"))
                        && user.getContrasenna()
                                .equals(rs.getString("contrasenna"))
                        && user.getTipo_Usuario() == rs.getInt("tipo_Usuario")) {
                    System.out.println("existe este usuario");
                    return true;

                } else {
                    System.out.println("no existe el usuario");

                    return false;

                }

            } else {
                return false;

            }

        } catch (Exception ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean clienteExists(Cliente cliente) {
        if (userExtendsExists(cliente, "cliente")) {
            PreparedStatement ps;
            ResultSet rs;
            
            try (var con = getConnection()) {
                
                
            } catch (SQLException ex) {
            return true;
            }
        }
        
        return false;
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
