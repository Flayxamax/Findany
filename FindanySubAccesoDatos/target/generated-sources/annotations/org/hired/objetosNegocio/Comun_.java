package org.hired.objetosNegocio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hired.objetosNegocio.Comentario;
import org.hired.objetosNegocio.Usuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T01:09:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comun.class)
public class Comun_ { 

    public static volatile SingularAttribute<Comun, Usuario> usuario;
    public static volatile SingularAttribute<Comun, Long> id;
    public static volatile ListAttribute<Comun, Comentario> comentario;

}