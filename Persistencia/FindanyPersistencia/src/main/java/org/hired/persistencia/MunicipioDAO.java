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
import org.bson.conversions.Bson;
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
}
