/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.interfaces.IEstadoDAO;

/**
 *
 * @author ildex
 */
public class EstadoDAO implements IEstadoDAO {

    private static EstadoDAO instancia;
    private final String NOMBRE_COLECCION = "Estado";

    public EstadoDAO() {

    }

    public static EstadoDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstadoDAO();
        }
        return instancia;
    }
    
    @Override
    public List<Estado> obtenerEstados() throws PersistenciaException {
        try {
            MongoCollection<Estado> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Estado.class);
            return coleccion.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener los estados: " + e.getLocalizedMessage());
        }
    }
}
