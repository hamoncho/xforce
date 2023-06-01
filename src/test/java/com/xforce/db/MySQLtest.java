/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.xforce.db;

import com.xforce.model.Admin;
import com.xforce.model.User;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hamoncho
 */
public class MySQLtest {

    @Test
    public void userNameExistsTest() throws Exception {
        MySQL mysql = new MySQL();

        assertTrue(mysql.userNameExists("axel"));
        assertTrue(mysql.userNameExists("isaac888"));
        assertFalse(mysql.userNameExists("vidal"));
        assertFalse(mysql.userNameExists("pedro"));

    }

    @Test
    public void emailExistsTest() throws Exception {
        MySQL mysql = new MySQL();

        assertTrue(mysql.emailExists("axel@gmail.com"));
        assertFalse(mysql.emailExists("hola@gmail.com"));

    }

    @Test
    public void getIdUsuarioTest() throws Exception {
        MySQL mysql = new MySQL();
        assertEquals(Optional.of(2),
                mysql.getIdUsuario("axel",
                        "FVp2qH6S@"));

    }

    @Test
    public void userExistsTest() throws Exception {
        User user = new User();

        user.setId_Usuario(2);
        user.setUsername("axel");
        user.setEmail("axel@gmail.com");
        user.setTelefono("452167339");
        user.setContrasenna("FVp2qH6S@");
        user.setTipo_Usuario(3);

        MySQL mysql = new MySQL();

        assertTrue(mysql.userExists(user));

    }

    @Test
    public void logInTest() throws Exception {
        User user = new User();

        user.setId_Usuario(2);
        user.setUsername("axel");
        user.setEmail("axel@gmail.com");
        user.setTelefono("452167339");
        user.setContrasenna("FVp2qH6S@");
        user.setTipo_Usuario(3);

        MySQL mysql = new MySQL();

        Optional<? extends User> optional = mysql.logIn("FVp2qH6S@", "axel");

        assertEquals(user.getUsername(), optional.get().getUsername());
        assertEquals(user.getEmail(), optional.get().getEmail());
        assertEquals(user.getTelefono(), optional.get().getTelefono());
        assertEquals(user.getContrasenna(), optional.get().getContrasenna());
        assertEquals(user.getTipo_Usuario(), optional.get().getTipo_Usuario());

    }

    @Test
    public void becomeAdmin() {
        try {
            User user = new User();

            user.setId_Usuario(2);
            user.setUsername("axel");
            user.setEmail("axel@gmail.com");
            user.setTelefono("452167339");
            user.setContrasenna("FVp2qH6S@");
            user.setTipo_Usuario(3);

            Admin admin = new Admin();

            admin.setId_Usuario(2);
            admin.setUsername("axel");
            admin.setEmail("axel@gmail.com");
            admin.setTelefono("452167339");
            admin.setContrasenna("FVp2qH6S@");
            admin.setTipo_Usuario(0);
            admin.setNombre("Axel");
            admin.setApellido("Alcantar");

            MySQL mysql = new MySQL();

            mysql.becomeAdmin(user, admin);
        } catch (Exception ex) {
            Logger.getLogger(MySQLtest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("");
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
     
    
     @Test
     public void user_add() {}
}
