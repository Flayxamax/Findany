/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 *
 * @author ildex
 */
public interface IActualizarUsuarioBO {

    public void modificarUsuario(Usuario usuario) throws NegocioException;
}
