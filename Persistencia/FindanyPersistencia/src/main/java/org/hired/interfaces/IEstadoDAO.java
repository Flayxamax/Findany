/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;

/**
 *
 * @author ildex
 */
public interface IEstadoDAO {

    public List<Estado> obtenerEstados() throws PersistenciaException;
}
