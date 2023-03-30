/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.xforce.db;

import com.xforce.model.User;
import com.xforce.model.UserType;

/**
 *
 * @author Hamoncho
 */
public interface DataBase {
    public UserType logIn(User user);
}
