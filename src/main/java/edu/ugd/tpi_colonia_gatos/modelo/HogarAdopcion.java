/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author wowle
 */



@Entity


public class HogarAdopcion extends Hogares implements Serializable{

    public HogarAdopcion(String direccion) {
        super(direccion);
    }

    public HogarAdopcion() {
    }
    
    
    
    
}
