/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */





@Entity
@Table(name = "Alimentacion")
public class Alimentacion extends Tarea implements Serializable{

    public Alimentacion() {
    }

    public Alimentacion( Voluntario voluntario, LocalDate fecha, LocalTime hora, String ubicacion) {
        super( voluntario, fecha, hora, ubicacion);
    }

    
    
}
