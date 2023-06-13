/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import DAO.ComentarioDAO;
import DAO.PostDAO;
import DAO.UsuarioDAO;
import interfaces.IComentarioDAO;
import interfaces.IPostDAO;
import interfaces.IUsuarioDAO;
import java.util.List;
import org.hired.objetosNegocio.Comentario;
import org.hired.objetosNegocio.Estado;
import org.hired.objetosNegocio.Municipio;
import org.hired.objetosNegocio.Post;
import org.hired.objetosNegocio.Usuario;

/**
 *
 * @author LV1822
 */
public class FindanyFachada {

    private final IUsuarioDAO usuarioDAO;
    private final IPostDAO postDAO;
    private final IComentarioDAO comentarioDAO;

    /**
     * Constructor de la fachada de acceso a datos.
     */
    public FindanyFachada() {
        usuarioDAO = new UsuarioDAO();
        postDAO = new PostDAO();
        comentarioDAO = new ComentarioDAO();
    }

    /**
     * Ingresa un nuevo usuario en la base de datos, asociado a un municipio y
     * estado.
     *
     * @param usuario Usuario a ingresar.
     * @param municipio Municipio al que pertenece el usuario.
     * @param estado Estado al que pertenece el municipio.
     */
    public void ingresarUsuario(Usuario usuario, Municipio municipio, Estado estado) {
        usuarioDAO.ingresarUsuario(usuario, municipio, estado);
    }

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param usuario Usuario a actualizar.
     */
    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.actualizarUsuario(usuario);
    }

    /**
     * Busca usuarios en la base de datos por su nombre completo.
     *
     * @param nombre El nombre completo del usuario a buscar.
     * @return Una lista de usuarios que coinciden con el nombre especificado.
     */
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        return usuarioDAO.buscarUsuarioPorNombre(nombre);
    }

    /**
     * Consulta los posts de un usuario.
     *
     * @param usuario Usuario del cual se quieren consultar los posts.
     * @return Lista de posts por usuario.
     */
    public List<Post> consultarPosts(Usuario usuario) {
        return postDAO.consultarPost(usuario);
    }

    /**
     * Consulta un post por su título.
     *
     * @param titulo Título del post.
     * @return Post encontrado.
     */
    public Post consultarPostPorTitulo(String titulo) {
        return postDAO.consultarPostTitulo(titulo);
    }

    /**
     * Crea un nuevo post.
     *
     * @param post Post a publicar.
     */
    public void crearPost(Post post) {
        postDAO.crearPost(post);
    }

    /**
     * Edita un post existente.
     *
     * @param post Post a editar.
     */
    public void editarPost(Post post) {
        postDAO.editarPost(post);
    }

    /**
     * Agrega un comentario a la base de datos.
     *
     * @param comentario Comentario a agregar.
     */
    public void agregarComentario(Comentario comentario) {
        comentarioDAO.agregarComentario(comentario);
    }

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario Comentario a eliminar.
     */
    public void eliminarComentario(Comentario comentario) {
        comentarioDAO.eliminarComentario(comentario);
    }

    /**
     * Consulta todos los comentarios asociados a un post específico.
     *
     * @param post Post para el cual se desean consultar los comentarios.
     * @return Una lista de comentarios asociados al post.
     */
    public List<Comentario> consultarComentariosPorPost(Post post) {
        return comentarioDAO.consultarComentariosPorPost(post);
    }

    /**
     * Consulta todos los comentarios que son respuestas a un comentario
     * específico.
     *
     * @param comentario Comentario para el cual se desean consultar las
     * respuestas.
     * @return Una lista de comentarios que son respuestas al comentario dado.
     */
    public List<Comentario> consultarComentariosPorComentario(Comentario comentario) {
        return comentarioDAO.consultarComentariosPorComentario(comentario);
    }

    /**
     * Consulta todos los comentarios almacenados en la base de datos.
     *
     * @return Una lista de todos los comentarios almacenados.
     */
    public List<Comentario> consultarTodosLosComentarios() {
        return comentarioDAO.consultarTodos();
    }
}
