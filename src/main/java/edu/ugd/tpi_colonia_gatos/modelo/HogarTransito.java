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


public class HogarTransito extends Hogares implements Serializable{

    public HogarTransito(String direccion) {
        super(direccion);
    }

    public HogarTransito() {
    }
    
    
}
