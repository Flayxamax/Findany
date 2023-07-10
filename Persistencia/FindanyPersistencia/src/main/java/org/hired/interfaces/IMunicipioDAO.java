/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;

/**
 * La interfaz IMunicipioDAO define las operaciones de acceso a datos relacionadas con los municipios.
 * 
 * @author HIRED
 */
public interface IMunicipioDAO {

    /**
     * Obtiene una lista de municipios por estado.
     *
     * @return una lista de municipios
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public List<Municipio> obtenerMunicipiosPorEstado() throws PersistenciaException;
    
    /**
     * Obtiene el municipio por su identificador.
     *
     * @param municipioId el identificador del municipio
     * @return el nombre del municipio encontrado
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public String obtenerMunicipioPorId(String municipioId) throws PersistenciaException;
    
    /**
     * Obtiene el estado por el identificador de un municipio.
     *
     * @param municipioId el identificador del municipio
     * @return el nombre del estado asociado al municipio
     * @throws PersistenciaException si ocurre un error durante la operación de persistencia
     */
    public String obtenerEstadoPorIdMunicipio(String municipioId) throws PersistenciaException;
}
