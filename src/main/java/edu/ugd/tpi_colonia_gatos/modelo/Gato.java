
package edu.ugd.tpi_colonia_gatos.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 *
 * @author wowle
 */

@Entity
public class Gato implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idGato;
    
    @Basic
    private String nombre;
    private String color;
    private String caracteristicas;
    private String foto; //va el link de la foto
   
    
    @OneToOne(cascade = CascadeType.ALL)
    private HistorialMedico medHistorial;
    
    @OneToOne
    private ZonasAvistamientos zonas;
   
    @Enumerated(EnumType.STRING)
    private EstadoSalud estadoActual;

     @Enumerated(EnumType.STRING)
    private EstadoAdopcion estado_adopcion;
    
    
      @Lob
    private String codigoQR; // ← guarda el QR en Base64 (imagen codificada)

    public HistorialMedico getMedHistorial() {
        return medHistorial;
    }

    public void setMedHistorial(HistorialMedico medHistorial) {
        this.medHistorial = medHistorial;
    }

    public Object getHistorial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
      
      
      
      
      
      public enum EstadoAdopcion {
        NOAPTO,
        APTO,
        ADOPTADO
        
    }
 
       
       
    public enum EstadoSalud {
        ENFERMO,
        SANO,
        EN_TRATAMIENTO,
        ESTERILIZADO,
        
    }

    public Gato() {
    }

    public Gato(String nombre, String color, String caracteristicas, String foto, EstadoSalud estadoActual, EstadoAdopcion estado_adopcion) {
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
        this.estadoActual = estadoActual;
        this.estado_adopcion = estado_adopcion;
   
    }

    public ZonasAvistamientos getZonas() {
        return zonas;
    }

    public void setZonas(ZonasAvistamientos zonas) {
        this.zonas = zonas;
    }

    
    public EstadoAdopcion getEstado_adopcion() {
        return estado_adopcion;
    }

    public void setEstado_adopcion(EstadoAdopcion estado_adopcion) {
        this.estado_adopcion = estado_adopcion;
    }
    
    
    
    
    
    
    
    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }


    
    
    
    public int getIdGato() {
        return idGato;
    }

    public void setIdGato(int idGato) {
        this.idGato = idGato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public EstadoSalud getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoSalud estadoActual) {
        this.estadoActual = estadoActual;
    }

    
    
    
    
    
    
    
    
}
