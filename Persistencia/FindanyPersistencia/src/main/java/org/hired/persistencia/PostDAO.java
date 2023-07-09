/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Post;
import org.hired.interfaces.IPostDAO;

/**
 *
 * @author wikit
 */
public class PostDAO implements IPostDAO {

    private static PostDAO instancia;
    private final String NOMBRE_COLECCION = "Post";

    public PostDAO() {
    }

    public static PostDAO getInstancia() {
        if (instancia == null) {
            instancia = new PostDAO();
        }
        return instancia;
    }

    @Override
    public Post crearPost(Post post) throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);
            coleccion.insertOne(post);
            return post;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al registrar usuario: " + e.getLocalizedMessage());
        }
    }

    @Override
    public Post actualizarPost(Post post) throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);
            Bson filtro = Filters.eq("_id", post.getId());
            coleccion.replaceOne(filtro, post);

            return post;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar el usuario: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void eliminarPost(Post post) throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);
            Bson filtro = Filters.eq("_id", post.getId());
            coleccion.deleteOne(filtro);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al eliminar el post: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Post> buscarPost(String busqueda) throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);
            Bson filtro = Filters.or(
                    Filters.text(busqueda), // Búsqueda de texto en contenido y título
                    Filters.eq("usuarioAutor", busqueda) // Búsqueda por autor
            );

            Bson orden = Sorts.ascending("tipo", "fechaHoraCreacion");

            MongoCursor<Post> cursor = coleccion.find(filtro).sort(orden).iterator();

            List<Post> resultados = new ArrayList<>();
            while (cursor.hasNext()) {
                resultados.add(cursor.next());
            }

            return resultados;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar los posts: " + e.getLocalizedMessage());
        }
    }

    @Override
    public Post buscarPorId(String postId) throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);
            ObjectId objectId = new ObjectId(postId);
            Bson filtro = Filters.eq("_id", objectId);
            return coleccion.find(filtro).first();
        } catch (IllegalArgumentException e) {
            throw new PersistenciaException("ID de post inválido: " + postId);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar el post por ID: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Post> buscarTodo() throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);

            Bson orden = Sorts.orderBy(Sorts.ascending("tipo"), Sorts.descending("fechaHoraCreacion"));

            MongoCursor<Post> cursor = coleccion.find().sort(orden).iterator();

            List<Post> resultados = new ArrayList<>();
            while (cursor.hasNext()) {
                resultados.add(cursor.next());
            }

            return resultados;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar los posts: " + e.getLocalizedMessage());
        }
    }

}
