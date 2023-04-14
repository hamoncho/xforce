/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.model;

import java.time.LocalDate;

/**
 *
 * @author hamoncho
 */
public class Cliente extends User {

    private String nombre;
    private String apellido;
    private String num_targeta;
    private LocalDate fecha_targeta;
    private LocalDate fecha_nacimiento;
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
     * Return credit card number
     *
     * @return {@code num_targeta}
     */
    public String getNum_targeta() {
        return num_targeta;
    }

    /**
     * Set credit card number
     *
     * @param num_targeta
     */
    public void setNum_targeta(String num_targeta) {
        this.num_targeta = num_targeta;
    }

    /**
     * Return credit card expiration date
     *
     * @return {@code fecha_targeta}
     */
    public LocalDate getFecha_targeta() {
        return fecha_targeta;
    }

    /**
     * Set credit card expiration date
     *
     * @param fecha_targeta
     */
    public void setFecha_targeta(LocalDate fecha_targeta) {
        this.fecha_targeta = fecha_targeta;
    }

    /**
     * Return birthdate
     *
     * @return {@code fecha_nacimiento}
     */
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Set birthdate
     *
     * @param fecha_nacimiento
     */
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
