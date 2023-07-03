/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;

/**
 *
 * @author ildex
 */
public interface IMunicipioDAO {

    public List<Municipio> obtenerMunicipiosPorEstado() throws PersistenciaException;
    
    public String obtenerMunicipioPorId(String municipioId) throws PersistenciaException;
    
    public String obtenerEstadoPorIdMunicipio(String municipioId) throws PersistenciaException;
}
