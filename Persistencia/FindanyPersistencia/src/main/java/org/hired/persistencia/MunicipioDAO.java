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
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.interfaces.IMunicipioDAO;

/**
 *
 * @author ildex
 */
public class MunicipioDAO implements IMunicipioDAO {

    private final String NOMBRE_COLECCION = "Municipio";
    private static MunicipioDAO instancia;

    public MunicipioDAO() {

    }

    public static MunicipioDAO getInstancia() {
        if (instancia == null) {
            instancia = new MunicipioDAO();
        }
        return instancia;
    }

    @Override
    public List<Municipio> obtenerMunicipiosPorEstado() throws PersistenciaException {
        try {
            MongoCollection<Municipio> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Municipio.class);
            return coleccion.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener los municipios por estado: " + e.getLocalizedMessage());
        }
    }

    public String obtenerMunicipioPorId(String municipioId) throws PersistenciaException {
        try {
            MongoCollection<Document> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION);
            Document filtro = new Document("_id", municipioId);
            Document municipio = coleccion.find(filtro).first();
            if (municipio != null) {
                return municipio.getString("nombre");
            } else {
                throw new PersistenciaException("No se encontró el municipio con el id: " + municipioId);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener el municipio: " + e.getLocalizedMessage());
        }
    }

    public String obtenerEstadoPorIdMunicipio(String municipioId) throws PersistenciaException {
        try {
            MongoCollection<Document> coleccionMunicipio = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION);
            Document municipio = coleccionMunicipio.find(Filters.eq("_id", municipioId)).first();

            if (municipio != null) {
                String estadoId = municipio.getString("estado");
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
