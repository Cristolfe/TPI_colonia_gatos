/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author wowle
 */

@Entity

@Table(name = "CertificadoAdopcion")
public class CertificadosAdopcion implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idCertificado;
    

    private LocalDate fechaAdop;
    
    
    @OneToOne
    private Gato gato;
    
    @OneToOne
    private Veterinario veterinario;

    public CertificadosAdopcion() {
    }

    public CertificadosAdopcion(LocalDate fechaAdop, Gato gato, Veterinario veterinario) {
        
        this.fechaAdop = fechaAdop;
        this.gato = gato;
        this.veterinario = veterinario;
    }

    public int getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
    }

    public LocalDate getFechaAdop() {
        return fechaAdop;
    }

    public void setFechaAdop(LocalDate fechaAdop) {
        this.fechaAdop = fechaAdop;
    }

    public Gato getGato() {
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    
    
    
    
    
}
