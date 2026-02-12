/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author wowle
 */




@Entity
public  class Tarea implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idTarea;
   
    private Voluntario voluntario;
    private LocalDate fecha;//posiblemente haya que cambiar por date
    private LocalTime hora;

    private String ubicacion;

    public Tarea() {
    }

    public Tarea(Voluntario voluntario, LocalDate fecha, LocalTime hora, String ubicacion) {
        this.idTarea = idTarea;
        this.voluntario = voluntario;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
    
    
    
    
}


