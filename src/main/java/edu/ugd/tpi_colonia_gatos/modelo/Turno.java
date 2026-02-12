/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author wowle
 */


@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;
    
    // Este será el título que verá FullCalendar (ej: "Sebas Tian - Alimentación")
    private String titulo; 
    
    // Usamos Date para la persistencia, luego en el Servlet lo formateamos a String ISO
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora; 

    // Relación simple o solo el nombre para el TPI
    private String nombreVoluntario;

    public Turno() {
    }

    public Turno(int idTurno, String titulo, Date fechaHora, String nombreVoluntario) {
        this.idTurno = idTurno;
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.nombreVoluntario = nombreVoluntario;
    }

    // GETTERS Y SETTERS
    public int getIdTurno() { return idTurno; }
    public void setIdTurno(int idTurno) { this.idTurno = idTurno; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public String getNombreVoluntario() { return nombreVoluntario; }
    public void setNombreVoluntario(String nombreVoluntario) { this.nombreVoluntario = nombreVoluntario; }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}