/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.hired.objetosNegocio.Comentario;
import org.hired.objetosNegocio.Post;

/**
 *
 * @author wikit
 */
public interface IComentarioDAO {

    /**
     * Agrega un comentario a la base de datos.
     *
     * @param comentario el comentario a agregar
     */
    public void agregarComentario(Comentario comentario);

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario el comentario a eliminar
     */
    public void eliminarComentario(Comentario comentario);

     /**
     * Consulta todos los comentarios que son respuestas a un comentario
     * específico.
     *
     * @param comentario el comentario para el cual se desean consultar las
     * respuestas
     * @return una lista de comentarios que son respuestas al comentario dado
     */
    public List<Comentario> consultarComentariosPorComentario(Comentario comentario);

    /**
     * Consulta todos los comentarios asociados a un post específico.
     *
     * @param post el post para el cual se desean consultar los comentarios
     * @return una lista de comentarios asociados al post
     */
    public List<Comentario> consultarComentariosPorPost(Post post);

    /**
     * Consulta todos los comentarios almacenados en la base de datos.
     *
     * @return una lista de todos los comentarios almacenados
     */
    public List<Comentario> consultarTodos();
}
