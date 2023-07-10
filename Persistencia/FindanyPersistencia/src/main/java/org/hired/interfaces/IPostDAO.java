/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Post;

/**
 * La interfaz IPostDAO define las operaciones de acceso a datos relacionadas con los posts.
 * 
 * @author HIRED
 */
public interface IPostDAO {

    /**
     * Crea un nuevo post.
     *
     * @param post el post a crear
     * @return el post creado
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public Post crearPost(Post post) throws PersistenciaException;

    /**
     * Actualiza un post existente.
     *
     * @param post el post a actualizar
     * @return el post actualizado
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public Post actualizarPost(Post post) throws PersistenciaException;

    /**
     * Elimina un post.
     *
     * @param post el post a eliminar
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public void eliminarPost(Post post) throws PersistenciaException;

    /**
     * Busca posts que coincidan con un término de búsqueda.
     *
     * @param busqueda el término de búsqueda
     * @return una lista de posts que coinciden con el término de búsqueda
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public List<Post> buscarPost(String busqueda) throws PersistenciaException;

    /**
     * Busca todos los posts existentes.
     *
     * @return una lista de todos los posts
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public List<Post> buscarTodo() throws PersistenciaException;

    /**
     * Busca un post por su identificador.
     *
     * @param postId el identificador del post a buscar
     * @return el post encontrado, o null si no se encuentra
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public Post buscarPorId(String postId) throws PersistenciaException;
}
