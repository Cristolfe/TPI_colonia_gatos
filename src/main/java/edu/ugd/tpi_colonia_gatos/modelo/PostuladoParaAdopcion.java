/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */





@Entity
@Table(name="PostuladoParaAdopcion")

public class PostuladoParaAdopcion implements Serializable{
    @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idPostulacion;
    
    
    @OneToOne
    private Gato gato;
    
    @OneToOne
    private Familia familia;
    
    
    private LocalDate fecha;
    
    private Boolean aceptado;

    public PostuladoParaAdopcion( Gato gato, Familia familia, LocalDate fecha, Boolean aceptado) {
        
        this.gato = gato;
        this.familia = familia;
        this.fecha = fecha;
        this.aceptado = aceptado;
    }

    public PostuladoParaAdopcion() {
    }

    public int getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(int idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public Gato getGato() {
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }
    
    
    
    
    
    
    
    
}
