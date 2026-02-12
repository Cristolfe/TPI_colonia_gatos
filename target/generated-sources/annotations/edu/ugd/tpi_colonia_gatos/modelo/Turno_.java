package edu.ugd.tpi_colonia_gatos.modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Date> fechaHora;
    public static volatile SingularAttribute<Turno, String> titulo;
    public static volatile SingularAttribute<Turno, String> nombreVoluntario;
    public static volatile SingularAttribute<Turno, Integer> idTurno;

}