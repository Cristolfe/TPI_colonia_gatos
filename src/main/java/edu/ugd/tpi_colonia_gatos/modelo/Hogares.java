/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author wowle
 */


@Entity


public class Hogares implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idHogar;
    
    
    private String direccion;

    public Hogares(String direccion) {
        this.direccion = direccion;
    }

    public Hogares() {
    }

    public int getIdHogar() {
        return idHogar;
    }

    public void setIdHogar(int idHogar) {
        this.idHogar = idHogar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
