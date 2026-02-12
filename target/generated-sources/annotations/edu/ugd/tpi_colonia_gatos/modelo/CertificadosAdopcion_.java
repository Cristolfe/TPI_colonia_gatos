package edu.ugd.tpi_colonia_gatos.modelo;

import edu.ugd.tpi_colonia_gatos.modelo.Gato;
import edu.ugd.tpi_colonia_gatos.modelo.Veterinario;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-01-23T10:05:12", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(CertificadosAdopcion.class)
public class CertificadosAdopcion_ { 

    public static volatile SingularAttribute<CertificadosAdopcion, LocalDate> fechaAdop;
    public static volatile SingularAttribute<CertificadosAdopcion, Veterinario> veterinario;
    public static volatile SingularAttribute<CertificadosAdopcion, Gato> gato;
    public static volatile SingularAttribute<CertificadosAdopcion, Integer> idCertificado;

}