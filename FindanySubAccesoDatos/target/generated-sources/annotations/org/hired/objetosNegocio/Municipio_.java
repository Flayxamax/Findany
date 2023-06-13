package org.hired.objetosNegocio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hired.objetosNegocio.Estado;
import org.hired.objetosNegocio.Usuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T02:47:06", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, Estado> estado;
    public static volatile ListAttribute<Municipio, Usuario> usuario;
    public static volatile SingularAttribute<Municipio, Long> id;
    public static volatile SingularAttribute<Municipio, String> nombre;

}