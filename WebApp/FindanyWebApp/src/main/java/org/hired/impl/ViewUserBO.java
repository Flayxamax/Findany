/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.IMunicipioDAO;
import org.hired.interfaces.IViewUserBO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class ViewUserBO implements IViewUserBO{
    
    FactoryPersistencia persistencia;
    IMunicipioDAO municipioDAO = persistencia.getMunicipioDAO();
    
    public ViewUserBO() {
        this.persistencia = new FactoryPersistencia();
    }
    
    @Override
    public String obtenerMunicipioId(String municipioId) throws PersistenciaException, NegocioException {
        try {
            String municipio = this.municipioDAO.obtenerMunicipioPorId(municipioId);
            return municipio;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
    
    @Override
    public String obtenerEstadoIdMunicipio(String municipioId) throws PersistenciaException, NegocioException {
        try {
            String municipio = this.municipioDAO.obtenerEstadoPorIdMunicipio(municipioId);
            return municipio;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
    
}
