/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.interfaces.IMunicipioDAO;

/**
 * La clase MunicipioDAO implementa la interfaz IMunicipioDAO y proporciona
 * métodos para acceder y manipular los datos de los municipios en la base de
 * datos. Utiliza la base de datos MongoDB para almacenar los datos de los
 * municipios. La clase utiliza el patrón Singleton para garantizar una única
 * instancia de la clase.
 *
 * @see FactoryPersistencia
 * @see Municipio
 * @author HIRED
 */
public class MunicipioDAO implements IMunicipioDAO {

    private final String NOMBRE_COLECCION = "Municipio";
    private static MunicipioDAO instancia;

    /**
     * Crea una nueva instancia de MunicipioDAO.
     */
    public MunicipioDAO() {

    }

    /**
     * Obtiene la instancia única de MunicipioDAO utilizando el patrón
     * Singleton.
     *
     * @return la instancia única de MunicipioDAO
     */
    public static MunicipioDAO getInstancia() {
        if (instancia == null) {
            instancia = new MunicipioDAO();
        }
        return instancia;
    }

    /**
     * Obtiene una lista de municipios por estado.
     *
     * @return una lista de municipios por estado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * obtener los municipios por estado
     */
    @Override
    public List<Municipio> obtenerMunicipiosPorEstado() throws PersistenciaException {
        try {
            MongoCollection<Municipio> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Municipio.class);
            return coleccion.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener los municipios por estado: " + e.getLocalizedMessage());
        }
    }

    /**
     * Obtiene el nombre de un municipio por su ID.
     *
     * @param municipioId el ID del municipio
     * @return el nombre del municipio
     * @throws PersistenciaException si ocurre un error durante la operación de
     * obtener el municipio por su ID
     */
    @Override
    public String obtenerMunicipioPorId(String municipioId) throws PersistenciaException {
        try {
            MongoCollection<Document> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION);
            Document filtro = new Document("_id", new ObjectId(municipioId));
            Document municipio = coleccion.find(filtro).first();
            if (municipio != null) {
                return municipio.getString("nombre");
            } else {
                throw new PersistenciaException("Error al encontrar el municipio con el id: " + municipioId);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener el municipio: " + e.getLocalizedMessage());
        }
    }

    /**
     * Obtiene el nombre del estado al que pertenece un municipio por su ID.
     *
     * @param municipioId el ID del municipio
     * @return el nombre del estado al que pertenece el municipio
     * @throws PersistenciaException si ocurre un error durante la operación de
     * obtener el estado por el ID del municipio
     */
    @Override
    public String obtenerEstadoPorIdMunicipio(String municipioId) throws PersistenciaException {
        try {
            MongoCollection<Document> coleccionMunicipio = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION);
            Document municipio = coleccionMunicipio.find(Filters.eq("_id", new ObjectId(municipioId))).first();

            if (municipio != null) {
                ObjectId estadoId = municipio.getObjectId("estado");
                MongoCollection<Document> estadosColeccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection("Estado");
                Document estado = estadosColeccion.find(Filters.eq("_id", estadoId)).first();

                if (estado != null) {
                    return estado.getString("nombre");
                } else {
                    throw new PersistenciaException("No se encontró el estado con el id: " + estadoId);
                }
            } else {
                throw new PersistenciaException("No se encontró el municipio con el id: " + municipioId);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener el estado por el id del municipio: " + e.getLocalizedMessage());
        }
    }

}
