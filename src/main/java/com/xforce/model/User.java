/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.xforce.model;

/**
 *
 * @author hamoncho
 */
public class User {

    private int id_Usuario;
    private String username;
    private String email;
    private String telefono;
    private String contrasenna;
    private int tipo_Usuario;

    /**
     * Return user id
     *
     * @return {@code id_Usuario}
     */
    public int getId_Usuario() {
        return id_Usuario;
    }

    /**
     * Set user id
     *
     * @param id_Usuario
     */
    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    /**
     * Return username
     *
     * @return {@code username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Return email
     *
     * @return {@code email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return phone
     *
     * @return {@code telefono}
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set phone
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Return password
     *
     * @return {@code contrasenna}
     */
    public String getContrasenna() {
        return contrasenna;
    }

    /**
     * Set password
     *
     * @param contrasenna
     */
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    /**
     * Return user type
     *
     * @return {@code tipo_Usuario}
     */
    public int getTipo_Usuario() {
        return tipo_Usuario;
    }

    /**
     * Set user type
     *
     * @param tipo_Usuario
     */
    public void setTipo_Usuario(int tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

}
