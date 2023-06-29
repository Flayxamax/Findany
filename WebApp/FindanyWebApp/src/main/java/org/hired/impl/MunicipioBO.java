/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.impl;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.interfaces.IMunicipioBO;
import org.hired.interfaces.IMunicipioDAO;
import org.hired.persistencia.FactoryPersistencia;

/**
 *
 * @author ildex
 */
public class MunicipioBO implements IMunicipioBO {

    FactoryPersistencia persistencia;
    IMunicipioDAO municipioDAO = persistencia.getMunicipioDAO();

    public MunicipioBO() {
        this.persistencia = new FactoryPersistencia();
    }

    @Override
    public List<Municipio> consultarMunicipiosPorEstado() throws NegocioException {
        try {
            List<Municipio> municipios = this.municipioDAO.obtenerMunicipiosPorEstado();
            return municipios;
        } catch (PersistenciaException e) {
            throw new NegocioException(e);
        }
    }
}
