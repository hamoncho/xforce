/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.model;

/**
 *
 * @author hamoncho
 */
public class Admin {

    private int id_Usuario;
    private String nombre;
    private String apellido;

    /**
     * Return user id
     *
     * @return (@code id_Usuario)
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
     * Return name
     *
     * @return (@code nombre)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set name
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Return last name
     *
     * @return (@code apellido)
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
