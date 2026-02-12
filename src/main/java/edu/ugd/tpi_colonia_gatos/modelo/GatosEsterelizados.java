/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author wowle
 */

public class GatosEsterelizados extends Reportes implements Serializable{
    
    
   
    private ArrayList<Gato> gatos = new ArrayList<>();

    public GatosEsterelizados() {
    }

    public GatosEsterelizados( LocalDate fecha) {
        super( fecha);
    }

    public ArrayList<Gato> getGatos() {
        return gatos;
    }

    public void setGatos(ArrayList<Gato> gatos) {
        this.gatos = gatos;
    }
    
    
    public void setGato(Gato gato) {
        this.gatos.add(gato);
    }
    
    
}
