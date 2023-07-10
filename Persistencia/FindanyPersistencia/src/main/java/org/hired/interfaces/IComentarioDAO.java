/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Comentario;

/**
 *
 * @author HIRED
 */
public interface IComentarioDAO {

    public Comentario crearComentario(Comentario comentario) throws PersistenciaException;

    public Comentario crearComentarioRespuesta(Comentario comentario) throws PersistenciaException;

    public List<Comentario> obtenerComentarios() throws PersistenciaException;
    
    public void eliminarComentario(Comentario comentario) throws PersistenciaException;
    
    public Comentario buscarComentarioPorId(String comentarioId) throws PersistenciaException;
}
