/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Comentario;

/**
 *
 * @author xeron
 */
public interface IComentarioBO {

    public Comentario crearComentario(Comentario comentario) throws NegocioException;

    public Comentario crearComentarioRespuesta(Comentario comentario) throws NegocioException;

    public List<Comentario> obtenerComentarios() throws NegocioException;

    public void eliminarComentario(Comentario comentario) throws NegocioException;
}
