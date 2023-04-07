/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.xforce.utils;

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
public class ValidateTest {
    /*
    public ValidateTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
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
    */

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void password(){
        //assertTrue(Validate.isPassword("Ya#Wm739"));
        assertTrue(Validate.isPassword("FVp2qH6S@"));
        assertTrue(Validate.isPassword("4DNXJ+a9"));
        assertTrue(Validate.isPassword("7b&HgN8h"));
        assertTrue(Validate.isPassword("sQ%yfTa3"));
        assertTrue(Validate.isPassword("?_YYXA@jqxQ*6_rnx8EE"));
        assertTrue(Validate.isPassword("44E&%KuT93oI"));
        assertTrue(Validate.isPassword("A8!hMi1O2"));

    }
    
    @Test
    public void password1(){
       assertTrue(Validate.isPassword("AaÑndreg@123"));
    }
    
    @Test
    public void password_null(){
       assertFalse(Validate.isPassword(null));
    }
}
