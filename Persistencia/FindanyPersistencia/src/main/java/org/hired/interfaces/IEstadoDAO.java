/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;

/**
 * La interfaz IEstadoDAO define las operaciones de acceso a datos relacionadas con los estados.
 * 
 * @author HIRED
 */
public interface IEstadoDAO {

    /**
     * Obtiene una lista de todos los estados.
     *
     * @return una lista de estados
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public List<Estado> obtenerEstados() throws PersistenciaException;
}

