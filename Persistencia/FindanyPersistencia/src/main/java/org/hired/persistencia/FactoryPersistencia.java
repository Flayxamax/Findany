/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import org.hired.interfaces.IUsuarioDAO;

/**
 *
 * @author ildex
 */
public class FactoryPersistencia {

    public FactoryPersistencia() {
    }
    
    public static IUsuarioDAO getUsuarioDAO(){
        return UsuarioDAO.getInstancia();
    }

}
