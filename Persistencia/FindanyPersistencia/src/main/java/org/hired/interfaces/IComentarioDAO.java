/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Comentario;

/**
 * La interfaz IComentarioDAO define las operaciones de acceso a datos
 * relacionadas con los comentarios.
 *
 * @author HIRED
 */
public interface IComentarioDAO {

    /**
     * Crea un nuevo comentario.
     *
     * @param comentario el comentario a crear
     * @return el comentario creado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Comentario crearComentario(Comentario comentario) throws PersistenciaException;

    /**
     * Crea un nuevo comentario como respuesta a otro comentario existente.
     *
     * @param comentario el comentario respuesta a crear
     * @return el comentario respuesta creado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Comentario crearComentarioRespuesta(Comentario comentario) throws PersistenciaException;

    /**
     * Obtiene una lista de todos los comentarios.
     *
     * @return una lista de comentarios
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public List<Comentario> obtenerComentarios() throws PersistenciaException;

    /**
     * Elimina un comentario.
     *
     * @param comentario el comentario a eliminar
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public void eliminarComentario(Comentario comentario) throws PersistenciaException;

    /**
     * Busca un comentario por su identificador.
     *
     * @param comentarioId el identificador del comentario a buscar
     * @return el comentario encontrado, o null si no se encuentra
     * @throws PersistenciaException si ocurre un error durante la operación de
     * persistencia
     */
    public Comentario buscarComentarioPorId(String comentarioId) throws PersistenciaException;
}
