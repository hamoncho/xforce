/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.model;

import java.time.LocalTime;

/**
 *
 * @author hamoncho
 */
public class Horario {

    private LocalTime lunes;
    private LocalTime martes;
    private LocalTime miercoles;
    private LocalTime jueves;
    private LocalTime viernes;
    private LocalTime sabado;
    private LocalTime domingo;

    /**
     * Return monday schedule
     *
     * @return {@code lunes}
     */
    public LocalTime getLunes() {
        return lunes;
    }

    /**
     * Set monday schedule
     *
     * @param lunes
     */
    public void setLunes(LocalTime lunes) {
        this.lunes = lunes;
    }

    /**
     * Return tuesday schedule
     *
     * @return {@code martes}
     */
    public LocalTime getMartes() {
        return martes;
    }

    /**
     * Set tuesday schedule
     *
     * @param martes
     */
    public void setMartes(LocalTime martes) {
        this.martes = martes;
    }

    /**
     * Return wednesday schedule
     *
     * @return {@code miercoles}
     */
    public LocalTime getMiercoles() {
        return miercoles;
    }

    /**
     * Set wednesday schedule
     *
     * @param miercoles
     */
    public void setMiercoles(LocalTime miercoles) {
        this.miercoles = miercoles;
    }

    /**
     * Return thursday schedule
     *
     * @return {@code jueves}
     */
    public LocalTime getJueves() {
        return jueves;
    }

    /**
     * Set thursday schedule
     *
     * @param jueves
     */
    public void setJueves(LocalTime jueves) {
        this.jueves = jueves;
    }

    /**
     * Return friday schedule
     *
     * @return {@code viernes}
     */
    public LocalTime getViernes() {
        return viernes;
    }

    /**
     * Set friday schedule
     *
     * @param viernes
     */
    public void setViernes(LocalTime viernes) {
        this.viernes = viernes;
    }

    /**
     * Return saturday schedule
     *
     * @return {@code sabado}
     */
    public LocalTime getSabado() {
        return sabado;
    }

    /**
     * Set saturday schedule
     *
     * @param sabado
     */
    public void setSabado(LocalTime sabado) {
        this.sabado = sabado;
    }

    /**
     * Return sunday schedule
     *
     * @return {@code domingo}
     */
    public LocalTime getDomingo() {
        return domingo;
    }

    /**
     * Set sunday schedule
     *
     * @param domingo
     */
    public void setDomingo(LocalTime domingo) {
        this.domingo = domingo;
    }

}
