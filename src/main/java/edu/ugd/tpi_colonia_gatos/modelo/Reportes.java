
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.time.LocalDate;

/**
 *
 * @author wowle
 */


public class Reportes {
  
       
    private LocalDate fecha;

    public Reportes() {
    }

    public Reportes(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

   
    
    
    
}
