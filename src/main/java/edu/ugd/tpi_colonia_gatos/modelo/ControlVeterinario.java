/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */


@Entity
@Table(name="ControlVeterinario")

public class ControlVeterinario extends Tarea implements Serializable {
    
    @OneToOne
    private Gato gato;

    public ControlVeterinario() {
    }

    public ControlVeterinario( Voluntario voluntario, LocalDate fecha, LocalTime hora, String ubicacion) {
        super(voluntario, fecha, hora, ubicacion);
    }

    public Gato getGato() {
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }
    
    
    
    
    
    
    
}
