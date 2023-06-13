package org.hired.objetosNegocio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hired.objetosNegocio.Municipio;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T01:09:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile ListAttribute<Estado, Municipio> municipio;
    public static volatile SingularAttribute<Estado, Long> id;
    public static volatile SingularAttribute<Estado, String> nombre;

}