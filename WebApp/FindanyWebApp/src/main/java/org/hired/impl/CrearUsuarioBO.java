/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import org.bson.types.ObjectId;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.ICrearUsuarioBO;
import org.hired.interfaces.IUsuarioDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class CrearUsuarioBO implements ICrearUsuarioBO {

    FactoryPersistencia persistencia;
    IUsuarioDAO usuarioDAO = persistencia.getUsuarioDAO();

    public CrearUsuarioBO() {
        this.persistencia = new FactoryPersistencia();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws PersistenciaException {
        try {
            Usuario usuarioGuardado = this.usuarioDAO.registrarUsuario(usuario);
            return usuarioGuardado;
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }
}
