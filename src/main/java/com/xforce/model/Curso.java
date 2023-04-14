/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xforce.model;

/**
 *
 * @author hamoncho
 */
public class Curso {

    private int id_Curso;
    private int id_Usuario;
    private String nombre;
    private String descripcion;
    private int id_horario_entrada;
    private int id_horario_salida;
    private Horario horario_entrada;
    private Horario horario_salida;
    private Sala sala;
    private int id_sala;
    private Instructor instructor;

    /**
     * Return course id
     *
     * @return {@code id_Curso}
     */
    public int getId_Curso() {
        return id_Curso;
    }

    /**
     * Set course id
     *
     * @param id_Curso
     */
    public void setId_Curso(int id_Curso) {
        this.id_Curso = id_Curso;
    }

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
     * Return description
     *
     * @return {@code descripcion}
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Set description
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Return gym start id
     *
     * @return {@code id_horario_entrada}
     */
    public int getId_horario_entrada() {
        return id_horario_entrada;
    }

    /**
     * Set gym start id
     *
     * @param id_horario_entrada
     */
    public void setId_horario_entrada(int id_horario_entrada) {
        this.id_horario_entrada = id_horario_entrada;
    }

    /**
     * Return gym exit id
     *
     * @return {@code id_horario_salida}
     */
    public int getId_horario_salida() {
        return id_horario_salida;
    }

    /**
     * Set gym exit id
     *
     * @param id_horario_salida
     */
    public void setId_horario_salida(int id_horario_salida) {
        this.id_horario_salida = id_horario_salida;
    }

    /**
     * Return gym start for the week
     *
     * @return {@code horario_entrada}
     */
    public Horario getHorario_entrada() {
        return horario_entrada;
    }

    /**
     * Set gym start for the week
     *
     * @param horario_entrada
     */
    public void setHorario_entrada(Horario horario_entrada) {
        this.horario_entrada = horario_entrada;
    }

    /**
     * Return gym exit for the week
     *
     * @return
     */
    public Horario getHorario_salida() {
        return horario_salida;
    }

    /**
     * Set gym exit for the week
     *
     * @param horario_salida
     */
    public void setHorario_salida(Horario horario_salida) {
        this.horario_salida = horario_salida;
    }

    /**
     * Return hall
     *
     * @return {@code sala}
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Set hall
     *
     * @param sala
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Return hall id
     *
     * @return {@code id_sala}
     */
    public int getId_sala() {
        return id_sala;
    }

    /**
     * Set hall id
     *
     * @param id_sala
     */
    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    /**
     * Return instructor
     *
     * @return {@code instructor}
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Set instructor
     *
     * @param instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
