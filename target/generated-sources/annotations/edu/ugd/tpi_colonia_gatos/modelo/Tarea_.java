package edu.ugd.tpi_colonia_gatos.modelo;

import edu.ugd.tpi_colonia_gatos.modelo.Voluntario;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Tarea.class)
public class Tarea_ { 

    public static volatile SingularAttribute<Tarea, LocalDate> fecha;
    public static volatile SingularAttribute<Tarea, String> ubicacion;
    public static volatile SingularAttribute<Tarea, Integer> idTarea;
    public static volatile SingularAttribute<Tarea, LocalTime> hora;
    public static volatile SingularAttribute<Tarea, Voluntario> voluntario;

}