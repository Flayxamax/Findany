/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import org.bson.types.ObjectId;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 *
 * @author ildex
 */
public interface ICrearUsuarioBO {

    public Usuario crearUsuario(Usuario usuario) throws PersistenciaException;
}
