/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.interfaces.IEstadoBO;
import org.hired.interfaces.IEstadoDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class EstadoBO implements IEstadoBO {

    FactoryPersistencia persistencia;
    IEstadoDAO estadoDAO = persistencia.getEstadoDAO();

    public EstadoBO() {
        this.persistencia = new FactoryPersistencia();
    }

    @Override
    public List<Estado> consultarEstados() throws NegocioException {
        try {
            List<Estado> estados = this.estadoDAO.obtenerEstados();
            return estados;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }

}
