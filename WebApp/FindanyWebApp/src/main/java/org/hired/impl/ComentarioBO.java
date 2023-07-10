/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.interfaces.IComentarioBO;
import org.hired.interfaces.IComentarioDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 * Clase de lógica de negocio para el manejo de comentarios.
 *
 * @author HIRED
 */
public class ComentarioBO implements IComentarioBO {

    FactoryPersistencia persistencia;
    IComentarioDAO comentarioDAO = persistencia.getComentarioDAO();

    /**
     * Crea una nueva instancia de ComentarioBO y realiza la inicialización de
     * la persistencia.
     */
    public ComentarioBO() {
        this.persistencia = new FactoryPersistencia();
    }

    /**
     * Crea un nuevo comentario.
     *
     * @param comentario el comentario a crear
     * @return el comentario creado
     * @throws NegocioException si ocurre un error durante la operación de
     * creación del comentario
     */
    @Override
    public Comentario crearComentario(Comentario comentario) throws NegocioException {
        try {
            Comentario comentarioNuevo = this.comentarioDAO.crearComentario(comentario);
            return comentarioNuevo;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    /**
     * Crea un nuevo comentario como respuesta a otro comentario.
     *
     * @param comentario el comentario respuesta a crear
     * @return el comentario respuesta creado
     * @throws NegocioException si ocurre un error durante la operación de
     * creación del comentario respuesta
     */
    @Override
    public Comentario crearComentarioRespuesta(Comentario comentario) throws NegocioException {
        try {
            Comentario respuestaNueva = this.comentarioDAO.crearComentarioRespuesta(comentario);
            return respuestaNueva;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    /**
     * Obtiene una lista de todos los comentarios.
     *
     * @return una lista de comentarios
     * @throws NegocioException si ocurre un error durante la operación de
     * obtención de comentarios
     */
    @Override
    public List<Comentario> obtenerComentarios() throws NegocioException {
        try {
            List<Comentario> comentarios = this.comentarioDAO.obtenerComentarios();
            return comentarios;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    /**
     * Elimina un comentario de la base de datos. Si el comentario es una
     * respuesta, se eliminará únicamente el comentario actual. Si el comentario
     * es un comentario padre, se eliminará el comentario actual y todas sus
     * respuestas.
     *
     * @param comentario el comentario a eliminar
     * @throws NegocioException si ocurre un error al eliminar el comentario
     */
    @Override
    public void eliminarComentario(Comentario comentario) throws NegocioException {
        try {
            this.comentarioDAO.eliminarComentario(comentario);
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public Comentario buscarComentarioPorId(String comentarioId) throws NegocioException {
        try {
            Comentario comentario = this.comentarioDAO.buscarComentarioPorId(comentarioId);
            return comentario;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
}
