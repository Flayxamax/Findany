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
 * La clase EstadoDAO implementa la interfaz IEstadoDAO y proporciona métodos
 * para acceder y manipular los datos de los estados en la base de datos.
 * Utiliza la base de datos MongoDB para almacenar los datos de los estados. La
 * clase utiliza el patrón Singleton para garantizar una única instancia de la
 * clase.
 *
 * @see IEstadoDAO
 * @see FactoryPersistencia
 * @see Estado
 * @author HIRED
 */
public class EstadoDAO implements IEstadoDAO {

    private static EstadoDAO instancia;
    private final String NOMBRE_COLECCION = "Estado";

    /**
     * Crea una nueva instancia de EstadoDAO.
     */
    public EstadoDAO() {

    }

    /**
     * Obtiene la instancia única de EstadoDAO utilizando el patrón Singleton.
     *
     * @return la instancia única de EstadoDAO
     */
    public static EstadoDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstadoDAO();
        }
        return instancia;
    }

    /**
     * Obtiene una lista de estados.
     *
     * @return una lista de estados
     * @throws PersistenciaException si ocurre un error durante la operación de
     * obtener los estados
     */
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
