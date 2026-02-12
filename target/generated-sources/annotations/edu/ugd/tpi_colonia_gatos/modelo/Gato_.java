package edu.ugd.tpi_colonia_gatos.modelo;

import edu.ugd.tpi_colonia_gatos.modelo.Gato.EstadoAdopcion;
import edu.ugd.tpi_colonia_gatos.modelo.Gato.EstadoSalud;
import edu.ugd.tpi_colonia_gatos.modelo.HistorialMedico;
import edu.ugd.tpi_colonia_gatos.modelo.ZonasAvistamientos;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Gato.class)
public class Gato_ { 

    public static volatile SingularAttribute<Gato, ZonasAvistamientos> zonas;
    public static volatile SingularAttribute<Gato, EstadoSalud> estadoActual;
    public static volatile SingularAttribute<Gato, String> caracteristicas;
    public static volatile SingularAttribute<Gato, String> color;
    public static volatile SingularAttribute<Gato, String> foto;
    public static volatile SingularAttribute<Gato, HistorialMedico> medHistorial;
    public static volatile SingularAttribute<Gato, EstadoAdopcion> estado_adopcion;
    public static volatile SingularAttribute<Gato, String> nombre;
    public static volatile SingularAttribute<Gato, String> codigoQR;
    public static volatile SingularAttribute<Gato, Integer> idGato;

}