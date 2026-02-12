/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author wowle
 */






public class GatosXZona extends Reportes implements Serializable {

   
  private Gato gato;

    public GatosXZona() {
    }

    public GatosXZona( LocalDate fecha) {
        super( fecha);
    }

    public Gato getGato() {
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }

  
  
    

    
    
}
