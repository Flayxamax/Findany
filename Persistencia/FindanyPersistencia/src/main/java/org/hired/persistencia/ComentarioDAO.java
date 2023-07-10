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
import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.interfaces.IComentarioDAO;

/**
 * Esta clase implementa la interfaz IComentarioDAO y proporciona métodos para
 * interactuar con la colección de comentarios en MongoDB. Utiliza la conexión a
 * la base de datos proporcionada por la clase ConexionMongoDB.
 *
 * @author HIRED
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

    /**
     * Elimina un comentario de la base de datos. Si el comentario es una
     * respuesta, se eliminará únicamente el comentario actual. Si el comentario
     * es un comentario padre, se eliminará el comentario actual y todas sus
     * respuestas.
     *
     * @param comentario el comentario a eliminar
     * @throws PersistenciaException si ocurre un error al eliminar el
     * comentario
     */
    @Override
    public void eliminarComentario(Comentario comentario) throws PersistenciaException {
        try {
            MongoCollection<Comentario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Comentario.class);

            if (comentario.getComentarioPadre() != null) {
                coleccion.deleteOne(Filters.eq("_id", comentario.getId()));
                System.out.println("Se ha eliminado el comentario actual: " + comentario);
            } else {
                eliminarComentarioPadreYRespuestas(coleccion, comentario);
                System.out.println("Se ha eliminado el comentario padre y todas sus respuestas: " + comentario);
            }
        } catch (MongoException e) {
            throw new PersistenciaException("Error al eliminar comentario: " + e.getLocalizedMessage());
        }
    }

    /**
     * Elimina un comentario padre y todas sus respuestas de forma recursiva.
     *
     * @param coleccion la colección de comentarios en la base de datos
     * @param comentario el comentario padre a eliminar
     */
    private void eliminarComentarioPadreYRespuestas(MongoCollection<Comentario> coleccion, Comentario comentario) {
        coleccion.deleteOne(Filters.eq("_id", comentario.getId()));
        List<Comentario> respuestas = coleccion.find(Filters.eq("comentarioPadre", comentario.getId())).into(new ArrayList<>());
        for (Comentario respuesta : respuestas) {
            eliminarComentarioPadreYRespuestas(coleccion, respuesta);
        }
    }

    @Override
    public Comentario buscarComentarioPorId(String comentarioId) throws PersistenciaException {
        try {
            MongoCollection<Comentario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Comentario.class);
            Bson filtro = Filters.eq("_id", new ObjectId(comentarioId));
            Comentario comentario = coleccion.find(filtro).first();
            return comentario;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar comentario por ID: " + e.getLocalizedMessage());
        }
    }

}
