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
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.interfaces.IComentarioDAO;

/**
 * Esta clase implementa la interfaz IComentarioDAO y proporciona métodos para
 * interactuar con la colección de comentarios en MongoDB. Utiliza la conexión a
 * la base de datos proporcionada por la clase ConexionMongoDB.
 *
 * @author Findany
 */
public class ComentarioDAO implements IComentarioDAO {

    private final String NOMBRE_COLECCION = "Comentario";
    private static ComentarioDAO instancia;

    /**
     * Crea una nueva instancia de ComentarioDAO.
     */
    public ComentarioDAO() {

    }

    /**
     * Obtiene la instancia única de ComentarioDAO utilizando el patrón
     * Singleton. Si no existe una instancia previa, crea una nueva y la
     * devuelve.
     *
     * @return la instancia única de ComentarioDAO
     */
    public static ComentarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new ComentarioDAO();
        }
        return instancia;
    }

    /**
     * Crea un nuevo comentario.
     *
     * @param comentario el comentario a crear
     * @return el comentario creado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * creación del comentario
     */
    @Override
    public Comentario crearComentario(Comentario comentario) throws PersistenciaException {
        try {
            MongoCollection<Comentario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Comentario.class);
            coleccion.insertOne(comentario);
            return comentario;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al crear comentario: " + e.getLocalizedMessage());
        }
    }

    /**
     * Crea un nuevo comentario como respuesta a otro comentario.
     *
     * @param comentario el comentario respuesta a crear
     * @return el comentario respuesta creado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * creación del comentario respuesta
     */
    @Override
    public Comentario crearComentarioRespuesta(Comentario comentario) throws PersistenciaException {
        try {
            MongoCollection<Comentario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Comentario.class);
            coleccion.insertOne(comentario);
            return comentario;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al crear comentario: " + e.getLocalizedMessage());
        }
    }

    /**
     * Obtiene una lista de todos los comentarios.
     *
     * @return una lista de comentarios
     * @throws PersistenciaException si ocurre un error durante la operación de
     * obtención de comentarios
     */
    @Override
    public List<Comentario> obtenerComentarios() throws PersistenciaException {
        try {
            MongoCollection<Comentario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Comentario.class);
            return coleccion.find().into(new ArrayList<>());
        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener comentarios: " + e.getLocalizedMessage());
        }
    }
}
