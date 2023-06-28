/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import org.hired.exception.PersistenciaException;
import org.hired.interfaces.IUsuarioDAO;

/**
 *
 * @author ildex
 */
public class FacadePersistencia {

    private final IUsuarioDAO usuarioDAO;

    public FacadePersistencia() {
        this.usuarioDAO = FactoryPersistencia.getUsuarioDAO();
    }

    public void registrarUsuario(Usuario usuario, Municipio municipio, Estado estado) throws PersistenciaException {
        this.usuarioDAO.registrarUsuario(usuario, municipio, estado);
    }

    public void actualizarUsuario(Usuario usuario, Municipio municipio, Estado estado) throws PersistenciaException {
        this.usuarioDAO.actualizarUsuario(usuario, municipio, estado);
    }

    public boolean autentificarUsuario(String correo, String contrasena) throws PersistenciaException {
        return this.usuarioDAO.autentificarUsuario(correo, contrasena);
    }
}
