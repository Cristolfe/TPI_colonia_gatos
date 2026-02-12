/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;


/**
 *
 * @author wowle
 */

@Entity
@Table(name = "HistorialMedico")

public class HistorialMedico implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idHistorial;
    
    private String descripcion;
      
   
    @OneToMany
   private List<Estudios> estudios = new ArrayList<>();
    
   
    @OneToMany
   private List<Diagnosticos> diagnosticos = new ArrayList<>();

    public HistorialMedico() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }


    public List<Estudios> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Estudios> estudios) {
        this.estudios = estudios;
    }
    
       public void setEstudio(Estudios e) {
        this.estudios.add(e);
    }

    public List<Diagnosticos> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnosticos> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
   
     public void setDiagnostico(Diagnosticos diagnosticos) {
        this.diagnosticos.add(diagnosticos);
    }
   
   
   
    
}
