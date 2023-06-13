package org.hired.objetosNegocio;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-13T01:09:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Post.class)
public abstract class Post_ { 

    public static volatile SingularAttribute<Post, LocalDateTime> fechaHoraEdicion;
    public static volatile SingularAttribute<Post, String> contenido;
    public static volatile SingularAttribute<Post, LocalDateTime> fechaHoraCreacion;
    public static volatile SingularAttribute<Post, String> titulo;
    public static volatile SingularAttribute<Post, Long> id;

}