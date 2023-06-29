/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import org.hired.interfaces.IUsuarioDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class CrearUsuarioBO {

    FactoryPersistencia persistencia;
    IUsuarioDAO usuarioDAO = persistencia.getUsuarioDAO();

    public CrearUsuarioBO() {
        this.persistencia = new FactoryPersistencia();
    }
    
    
}
