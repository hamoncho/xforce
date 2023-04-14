/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.model;

/**
 *
 * @author hamoncho
 */
public class Instructor extends User {

    private String nombre;
    private String apellido;
    private String tipo_sanguineo;

    /**
     * Return name
     *
     * @return {@code nombre}
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
     * @return {@code apellido}
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Set last name
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Return blood type
     *
     * @return {@code tipo_sanguineo}
     */
    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    /**
     * Set blood type
     *
     * @param tipo_sanguineo
     */
    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

}
