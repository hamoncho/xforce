/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.utils;

/**
 *
 * @author hamoncho
 */
public class Validate {

    public static boolean isName(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean isEmail(String email) {
        return email.matches("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+/[\\w-]+$");
    }

    public static boolean isPhone(String phone) {
        return phone.matches("[1-9]\\d{8}");
    }

    /**
     *
     * <b>Valida si la contraseña cumple las siguientes caracteristicas.</b>
     *
     * <br>
     * <ul>
     * <li>Contiene al menos 8 caracteres y como máximo 20 caracteres.</li>
     * <li>Contiene al menos un dígito.</li>
     * <li>Contiene al menos un alfabeto en mayúsculas.</li>
     * <li>Contiene al menos un alfabeto en minúsculas. </li>
     * <li>Contiene al menos un carácter especial que incluye
     * !@#$%&*()-+=^.</li>
     * <li>No contiene ningún espacio en blanco.</li>
     * </ul>
     * 
     *
     *
     * <b> Ejemplos:</b>
     * <dl>
     * <dt>Entrada:</dt> <dd>Geeks@portal20</dd>

     * <dt>Salida:</dt> <dd><code>true </code></dd>
     * <dt>Explicación:</dt>
     * <dd>
     * Esta contraseña cumple con todas las restricciones mencionadas
     * anteriormente.
     * </dd>
     * </dl>
     * 
     * <dl>
     * 
     * <dt>Entrada:</dt> <dd>Geeksforgeeks</dd>
     * 
     * <dt>Salida:</dt> <dd><code>false</code></dd>
     * 
     * <dt>Explicación:</dt>
     * <dd>
     * contiene letras mayúsculas y minúsculas, pero no
     * contiene dígitos ni caracteres especiales.
     * </dd>
     * 
     * </dl>
     * 
     * <dl>
     * <dt>Entrada:</dt> <dd>Geeks@ portal9</dd>
     * <dt>Salida:</dt> <dd><code> false</code></dd>
     * 
     * <dt>Explicación:</dt> 
     * <dd>
     * contiene letras en mayúsculas, letras en minúsculas,
     * caracteres especiales, dígitos y espacios en blanco que no son válidos.
     * </dd>
     * 
     * <b>Entrada:</b> Str = 12345
     * <br>
     * <b>Salida:</b> Falso.
     * <br>
     * <b>Explicación:</b>
     * contiene solo dígitos, pero no contiene alfabeto en mayúsculas, alfabeto
     * en minúsculas, caracteres especiales y 8 caracteres.
     * 
     * </dl>
     * 
     * 
     * 
     * @param password
     * @return <code>true</code> if password is validate else return <code>false</code>
     */
    public static boolean isPassword(String password) {
        return password.matches("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$");
    }
}
