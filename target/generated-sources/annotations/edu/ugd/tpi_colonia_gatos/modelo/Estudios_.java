package edu.ugd.tpi_colonia_gatos.modelo;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Estudios.class)
public class Estudios_ { 

    public static volatile SingularAttribute<Estudios, String> descripcion;
    public static volatile SingularAttribute<Estudios, LocalDate> fecha;
    public static volatile SingularAttribute<Estudios, Integer> idEstudio;

}