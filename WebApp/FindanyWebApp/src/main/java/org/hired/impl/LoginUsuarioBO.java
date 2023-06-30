/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.ILoginUsuarioBO;
import org.hired.interfaces.IUsuarioDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class LoginUsuarioBO implements ILoginUsuarioBO {

    FactoryPersistencia persistencia;
    IUsuarioDAO usuarioDAO = persistencia.getUsuarioDAO();

    public LoginUsuarioBO() {
        this.persistencia = new FactoryPersistencia();
    }

    @Override
    public boolean AuthUsuario(String correo, String contrasena) throws NegocioException {
        try {
            boolean usuarioLogueado = this.usuarioDAO.autentificarUsuario(correo, contrasena);
            return usuarioLogueado;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

    @Override
    public Usuario busquedaUsuario(String correo) throws NegocioException {
        try {
            Usuario usuarioLogueado = this.usuarioDAO.buscarUsuarioPorCorreo(correo);
            return usuarioLogueado;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
}
