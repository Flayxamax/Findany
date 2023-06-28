/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import org.hired.dominio.Estado;
import org.hired.dominio.Municipio;
import org.hired.dominio.Usuario;
import org.hired.exception.PersistenciaException;

/**
 *
 * @author ildex
 */
public interface IUsuarioDAO {

    public void registrarUsuario(Usuario usuario, Municipio municipio, Estado estado) throws PersistenciaException;

    public void actualizarUsuario(Usuario usuario, Municipio municipio, Estado estado) throws PersistenciaException;
    
    public boolean autentificarUsuario(String correo, String contrasena) throws PersistenciaException;
}
