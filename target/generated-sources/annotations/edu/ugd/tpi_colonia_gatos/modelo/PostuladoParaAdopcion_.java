package edu.ugd.tpi_colonia_gatos.modelo;

import edu.ugd.tpi_colonia_gatos.modelo.Familia;
import edu.ugd.tpi_colonia_gatos.modelo.Gato;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PostuladoParaAdopcion.class)
public class PostuladoParaAdopcion_ { 

    public static volatile SingularAttribute<PostuladoParaAdopcion, LocalDate> fecha;
    public static volatile SingularAttribute<PostuladoParaAdopcion, Boolean> aceptado;
    public static volatile SingularAttribute<PostuladoParaAdopcion, Gato> gato;
    public static volatile SingularAttribute<PostuladoParaAdopcion, Integer> idPostulacion;
    public static volatile SingularAttribute<PostuladoParaAdopcion, Familia> familia;

}