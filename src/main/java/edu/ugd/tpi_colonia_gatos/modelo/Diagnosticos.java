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
import javax.persistence.OneToOne;


/**
 *
 * @author wowle
 */


@Entity
public class Diagnosticos implements Serializable {
   
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idDiagnostico;
     
    @OneToOne
    private Tratamiento tratamiento;
     
     private String descripcion;

    public Diagnosticos() {
    }

    public Diagnosticos( String descripcion) {
        this.idDiagnostico = idDiagnostico;
        this.descripcion = descripcion;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento; // Asignación real
    }

    
    public Tratamiento getTratamiento() {
        return tratamiento;
    }
     
    
    
}
