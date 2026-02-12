/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */





@Entity
@Table(name="Familia")
public class Familia extends Usuario implements Serializable{

    public Familia(int dni, String nombre, String apellido, String direccion, String pass, Date fechNac) {
        super(dni, nombre, apellido, direccion, pass, fechNac);
    }

    public Familia() {
    }
 
    
    
    
}
