/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Post;

/**
 *
 * @author wikit
 */
public interface IPostDAO {

    public Post crearPost(Post post) throws PersistenciaException;

    public Post actualizarPost(Post post) throws PersistenciaException;

    public void eliminarPost(Post post) throws PersistenciaException;

    public List<Post> buscarPost(String busqueda) throws PersistenciaException;

    public List<Post> buscarTodo() throws PersistenciaException;

    public Post buscarPorId(String postId) throws PersistenciaException;
}
