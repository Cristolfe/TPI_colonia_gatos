/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */

@Entity
@Table(name = "ZonasAvistamientos")
public class ZonasAvistamientos implements Serializable {
    
      @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idAvistamiento;
    
      
    @Basic
    private String nombreZona;
 
  

    public ZonasAvistamientos() {
    }

    public ZonasAvistamientos(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public int getIdAvistamiento() {
        return idAvistamiento;
    }

    public void setIdAvistamiento(int idAvistamiento) {
        this.idAvistamiento = idAvistamiento;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

  @Override
public String toString() {
    return nombreZona;
}

    
}
