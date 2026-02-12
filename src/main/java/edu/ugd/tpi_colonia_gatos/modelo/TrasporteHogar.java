/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */



@Entity
@Table(name="TrasporteHogar")
public class TrasporteHogar extends Tarea{
    
 
    
    private String descripcion;
    private Hogares hogar;

    public TrasporteHogar() {
    }

    public TrasporteHogar(String descripcion, Hogares hogar) {
        
        this.descripcion = descripcion;
        this.hogar = hogar;
    }

 

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    public Hogares getHogar() {
        return hogar;
    }

    public void setHogar(Hogares hogar) {
        this.hogar = hogar;
    }

    public TrasporteHogar(Voluntario voluntario, LocalDate fecha, LocalTime hora, String ubicacion) {
        super(voluntario, fecha, hora, ubicacion);
    }
    
    
    
    
    
    
    
}
