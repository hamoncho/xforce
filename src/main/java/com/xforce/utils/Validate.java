/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.utils;

/**
 * Util class
 *
 * @author hamoncho
 */
public class Validate {

    public static boolean isNumber(String number) {
        return number.matches("\\d");
    }

    public static boolean isNumber(String number, int bound) {
        return number.matches("");
    }

    /**
     * verify that parameter {@code name} is a name validate.
     *
     * valid if parameter {@code name} meets the following characteristics.
     * <ul>
     * <li>Contains only characters.</li>
     * </ul>
     *
     * @param name a {@code String}
     * @return {@code true} if parameter name is validate else return
     * {@code false}
     *
     */
    public static boolean isName(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean isName(String name, int bound) {
        return name.matches("");
    }

    /**
     * valid if the parameter {@code email} meets the following characteristics.
     * <ul>
     * <li>Contains 8 characters.</li>
     * <li>All characters are digit.</li>
     * </ul>
     *
     * @param email
     * @return {@code true} if the parameter {@code email} is validate else
     * return {@code false}
     */
    public static boolean isEmail(String email) {
        return email.matches("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+/[\\w-]+$");
    }

    /**
     * Valid if the parameter {@code phone} meets the following characteristics.
     * <ul>
     * <li>Contains 8 characters.</li>
     * <li>All characters are digit.</li>
     * </ul>
     *
     * @param phone
     * @return return {@code true} if number phone is validate else return
     * {@code false}
     */
    public static boolean isPhone(String phone) {
        return phone.matches("[1-9]\\d{8}");
    }

    /**
     * 
     * Valid if the parameter {@code password} meets the following
     * characteristics.
     *
     * <ul>
     * <li>Contains at least 8 characters and a maximum of 20 characters.</li>
     * <li>Contains at least one digit.</li>
     * <li>Contains at least one uppercase alphabet.</li>
     * <li>Contains at least one lowercase alphabet. </li>
     * <li>Contains at least one special character including !@#$%&*()-+=^.</li>
     * <li>Does not contain any blank spaces.</li>
     * </ul>
     *
     *
     *
     * <b> Examples:</b>
     * <dl>
     * <dt>Input:</dt> <dd>Geeks@portal20</dd>
     *
     * <dt>Output:</dt> <dd>{@code true}</dd>
     * <dt>Explanation:</dt>
     * <dd>
     * This password complies with all the restrictions mentioned above.
     * </dd>
     * </dl>
     *
     * <dl>
     * <dt>Input:</dt> <dd>Geeksforgeeks</dd>
     *
     * <dt>Output:</dt> <dd>{@code false}</dd>
     *
     * <dt>Explanation:</dt>
     * <dd>
     * contains uppercase and lowercase letters, but does not contain digits or
     * special characters.
     * </dd>
     *
     * </dl>
     * 
     * @param password a {@code String}
     *
     * @return {@code true} if the parameter {@code password} password is
     * validate else return {@code false} or
     * if parameter {@code password} is {@code null} return {@code false}
     */
    public static boolean isPassword(String password) {
        if(password == null){
            return false;
        }
        return password.matches("^(?=.*[0-9])" //Contains at least one digit.
                + "(?=.*[a-z])" //Contains at least one uppercase alphabet.
                + "(?=.*[A-Z])" //Contains at least one uppercase alphabet.
                + "(?=.*[@#$%^&+=])" //Contains at least one !@#$%&*()-+=^
                + "(?=\\S+$).{8,20}$");//Contains at least 8 and a maximum of 20 characters.
    }
}
