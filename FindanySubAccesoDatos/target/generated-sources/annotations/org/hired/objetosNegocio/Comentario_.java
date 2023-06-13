package org.hired.objetosNegocio;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.hired.objetosNegocio.Comentario;
import org.hired.objetosNegocio.Comun;
import org.hired.objetosNegocio.Normal;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T02:47:06", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Normal> normal;
    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, LocalDateTime> fechaHora;
    public static volatile SingularAttribute<Comentario, Long> id;
    public static volatile SingularAttribute<Comentario, Comentario> comentario;
    public static volatile SingularAttribute<Comentario, Comun> comun;

}