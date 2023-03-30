/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.xforce.model;

/**
 *
 * @author hamoncho
 */
public record User(
        int id_user,
        String userName,
        String phone,
        String password,
        String email,
        String name,
        String lastNames,
        UserType userType) {}
