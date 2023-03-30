/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.xforce.model;

/**
 *
 * @author hamoncho
 */
public enum UserType {
    NO_USER("",""),
    DEFAULT("",""),
    CUSTOMER("",""),
    ADMINISTRATOR("root","4521353349");
    
    private final String dbUser;
    private final String dbPassword;
    
    UserType(String dbUser, String dbPassword){
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    
    public String getDbPassword(){
        return this.dbPassword;
    }
    
    public String getDbUser(){
        return this.dbUser;
    }
}
