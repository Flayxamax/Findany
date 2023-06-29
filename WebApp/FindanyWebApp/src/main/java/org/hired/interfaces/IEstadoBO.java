/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import java.util.List;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Estado;

/**
 *
 * @author ildex
 */
public interface IEstadoBO {

    public List<Estado> consultarEstados() throws NegocioException;
}
