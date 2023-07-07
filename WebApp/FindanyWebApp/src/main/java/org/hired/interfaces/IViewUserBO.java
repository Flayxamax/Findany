/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;

/**
 *
 * @author ildex
 */
public interface IViewUserBO {

    public String obtenerMunicipioId(String municipioId) throws PersistenciaException, NegocioException;

    public String obtenerEstadoIdMunicipio(String municipioId) throws PersistenciaException, NegocioException;
}
