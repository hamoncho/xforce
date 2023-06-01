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
import java.util.ArrayList;
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

        try (var con = getConnection()) {
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

    public ArrayList<User> getAllUser() {
        ArrayList<User> listUser = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try (var con = getConnection()) {
            var query = "SELECT * FROM usuario";

            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId_Usuario(rs.getInt("id_Usuario"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setTelefono(rs.getString("telefono"));
                user.setContrasenna(rs.getString("contrasenna"));
                user.setTipo_Usuario(rs.getInt("tipo_Usuario"));

                listUser.add(user);

            }

        } catch (SQLException ex) {
            System.out.println("Error en getAllUser");
        }

        return listUser;
    }

    /**
     * sign in a user
     *
     * @param {@code user}
     *
     */
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

        try (var con = getConnection()) {

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

        try (var con = getConnection()) {
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

        try (var con = getConnection()) {
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

        try (var con = getConnection()) {
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

            try (var con = getConnection()) {
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

        try (var con = getConnection()) {
            var query = "SELECT * FROM " + tabla + " WHERE id_Usuario = ?;";

            ps = con.prepareStatement(query);

            ps.setString(1, "" + user.getId_Usuario());

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
        if (!userExists(current)) {
            throw new Exception("The user not exists.");

        }
        if (target.getId_Usuario() != current.getId_Usuario()) {
            throw new IllegalArgumentException(
                    "The id of the current and target do not match.");

        }
        if (!target.getUsername().equals(current.getUsername())) {
            throw new IllegalArgumentException(
                    "The username of the current and target do not match.");
        }
        if (!target.getEmail().equals(current.getEmail())) {
            throw new IllegalArgumentException(
                    "The email of the current and target do not match.");

        }
        if (!target.getTelefono().equals(current.getTelefono())) {
            throw new IllegalArgumentException(
                    "The phone of the current and target do not match.");

        }
        if (!target.getContrasenna().equals(current.getContrasenna())) {
            System.out.println(target.getContrasenna() + " no concide con " + current.getContrasenna());

            throw new IllegalArgumentException(
                    "The password of the current and target do not match.");

        }
//        if (current.getTipo_Usuario() != 3) {
//            throw new IllegalArgumentException(
//                    "The user type does not have permission to be admin.");
//
//        }


        PreparedStatement ps;

        try (var con = getConnection()) {
            var query = "INSERT INTO xforce.admin"
                    + "(id_Usuario, Nombre, Apellido) "
                    + "VALUES(?, ?, ?);";

            ps = con.prepareStatement(query);

            ps.setString(1, "" + target.getId_Usuario());
            ps.setString(2, target.getNombre());
            ps.setString(3, target.getApellido());

            ps.execute();

            ps.execute("UPDATE usuario SET tipo_Usuario = 0 WHERE id_Usuario = " + current.getId_Usuario() + ";");
            ps.execute("DELETE FROM `cliente` WHERE id_Usuario = " + current.getId_Usuario());
            
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void becomeCliente(User current, Cliente target) throws Exception, IllegalArgumentException {
        String sql = "INSERT INTO cliente (id_Usuario, Nombre, Apellido, Num_Tarjeta, Fecha_Tarjeta, Fecha_Nacimiento, Tipo_Sanguineo) VALUES (?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setInt(1, current.getId_Usuario());
        pstmt.setString(2, target.getNombre());
        pstmt.setString(3, target.getApellido());
        pstmt.setString(4, target.getNum_targeta());
        pstmt.setString(5, target.getFecha_targeta().toString());
        pstmt.setString(6, target.getFecha_nacimiento().toString());
        pstmt.setString(7, target.getTipo_sanguineo());
        // pstmt.setInt(8, current.getId_Usuario());

        int filasAfectadas = pstmt.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Se insertó el nuevo cliente correctamente.");
        } else {
            System.out.println("No se pudo insertar el nuevo cliente.");
        }
        pstmt.execute("UPDATE usuario SET tipo_Usuario = 1 WHERE id_Usuario = " + current.getId_Usuario() + ";");

        pstmt.execute("DELETE FROM `admin` WHERE id_Usuario = " + current.getId_Usuario());

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
        try {
            String sql = "DELETE FROM usuario WHERE id_Usuario = ?";

            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se eliminó la fila correctamente.");
            } else {
                System.out.println("No se encontró ninguna fila para eliminar.");
            }

            pstmt.execute("DELETE FROM `admin` WHERE id_Usuario = " + id);
            pstmt.execute("DELETE FROM `cliente` WHERE id_Usuario = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateUser(int id, User userUpdate) {
        // UPDATE usuario SET tipo_Usuario = 1 WHERE id_Usuario = ?;

    }

//
}
