package edu.ugd.tpi_colonia_gatos.modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Date> fechNac;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Integer> dni;

}