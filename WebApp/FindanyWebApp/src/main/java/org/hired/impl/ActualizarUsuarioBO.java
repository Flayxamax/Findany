/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.IActualizarUsuarioBO;
import org.hired.interfaces.IUsuarioDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class ActualizarUsuarioBO implements IActualizarUsuarioBO {

    FactoryPersistencia persistencia;
    IUsuarioDAO usuarioDAO = persistencia.getUsuarioDAO();

    public ActualizarUsuarioBO() {
        this.persistencia = new FactoryPersistencia();
    }
    
    @Override
    public void modificarUsuario(Usuario usuario) throws NegocioException {
        try {
            this.usuarioDAO.actualizarUsuario(usuario);
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
}
