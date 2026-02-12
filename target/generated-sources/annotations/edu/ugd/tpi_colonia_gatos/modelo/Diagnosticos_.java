package edu.ugd.tpi_colonia_gatos.modelo;

import edu.ugd.tpi_colonia_gatos.modelo.Tratamiento;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Diagnosticos.class)
public class Diagnosticos_ { 

    public static volatile SingularAttribute<Diagnosticos, String> descripcion;
    public static volatile SingularAttribute<Diagnosticos, Integer> idDiagnostico;
    public static volatile SingularAttribute<Diagnosticos, Tratamiento> tratamiento;

}