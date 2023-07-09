/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Post;
import org.hired.interfaces.IPostBO;
import org.hired.interfaces.IPostDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author wikit
 */
public class PostBO implements IPostBO {

    FactoryPersistencia persistencia;
    IPostDAO postDAO = persistencia.getPostDAO();

    public PostBO() {
        this.persistencia = new FactoryPersistencia();
    }

    @Override
    public Post crearPost(Post post) throws NegocioException {
        try {
            Post postGuardado = this.postDAO.crearPost(post);
            return postGuardado;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public Post actualizarPost(Post post) throws NegocioException {
        try {
            Post postGuardado = this.postDAO.actualizarPost(post);
            return postGuardado;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public void eliminarPost(Post post) throws NegocioException {
        try {
            this.postDAO.eliminarPost(post);
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public List<Post> buscarPost(String busqueda) throws NegocioException {
        try {
            List<Post> feed = this.postDAO.buscarPost(busqueda);
            return feed;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public List<Post> buscarTodo() throws NegocioException {
        try {
            List<Post> feed = this.postDAO.buscarTodo();
            return feed;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public Post buscarPorId(String postId) throws NegocioException {
        try {
            Post post = this.postDAO.buscarPorId(postId);
            return post;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
}
