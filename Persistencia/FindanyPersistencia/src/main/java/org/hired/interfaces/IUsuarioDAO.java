/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 *
 * @author ildex
 */
public interface IUsuarioDAO {

    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException;
    
    public boolean existeCorreoRegistrado(String correo) throws PersistenciaException;

    public void actualizarUsuario(Usuario usuario, Municipio municipio, ObjectId estado) throws PersistenciaException;
    
    public boolean autentificarUsuario(String correo, String contrasena) throws PersistenciaException;
}
