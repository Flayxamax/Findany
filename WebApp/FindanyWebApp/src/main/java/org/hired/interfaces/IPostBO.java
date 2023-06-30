/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Post;

/**
 *
 * @author wikit
 */
public interface IPostBO {
    public Post crearPost(Post post) throws NegocioException;

    public Post actualizarPost(Post post) throws NegocioException;

    public void eliminarPost(Post post) throws NegocioException;
    
    public List<Post> buscarPost(String busqueda) throws NegocioException;
    
    public List<Post> buscarTodo() throws NegocioException;
}
