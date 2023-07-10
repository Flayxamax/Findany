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
import java.util.regex.Pattern;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Post;
import org.hired.interfaces.IPostDAO;

/**
 * La clase PostDAO implementa la interfaz IPostDAO y proporciona métodos para
 * acceder y manipular los datos de los posts en la base de datos. Utiliza la
 * base de datos MongoDB para almacenar los datos de los posts. La clase utiliza
 * el patrón Singleton para garantizar una única instancia de la clase.
 *
 * @see FactoryPersistencia
 * @see Post
 * @author HIRED
 */
public class PostDAO implements IPostDAO {

    private static PostDAO instancia;
    private final String NOMBRE_COLECCION = "Post";

    /**
     * Crea una nueva instancia de PostDAO.
     */
    public PostDAO() {
    }

    /**
     * Obtiene la instancia única de PostDAO utilizando el patrón Singleton.
     *
     * @return la instancia única de PostDAO
     */
    public static PostDAO getInstancia() {
        if (instancia == null) {
            instancia = new PostDAO();
        }
        return instancia;
    }

    /**
     * Crea un nuevo post en la base de datos.
     *
     * @param post el post a crear
     * @return el post creado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * creación del post
     */
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

    /**
     * Crea un nuevo post en la base de datos.
     *
     * @param post el post a crear
     * @return el post creado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * creación del post
     */
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

    /**
     * Elimina un post de la base de datos.
     *
     * @param post el post a eliminar
     * @throws PersistenciaException si ocurre un error durante la operación de
     * eliminación del post
     */
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

    /**
     * Busca posts en la base de datos que coincidan con el criterio de
     * búsqueda.
     *
     * @param busqueda el término de búsqueda
     * @return una lista de posts que coinciden con el criterio de búsqueda
     * @throws PersistenciaException si ocurre un error durante la operación de
     * búsqueda de posts
     */
    @Override
    public List<Post> buscarPost(String busqueda) throws PersistenciaException {
        try {
            MongoCollection<Post> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Post.class);
            String regexPattern = "(?i).*" + Pattern.quote(busqueda) + ".*"; // Aplicar insensibilidad a mayúsculas y minúsculas
            Bson filtro = Filters.or(
                    Filters.regex("contenido", regexPattern),
                    Filters.regex("titulo", regexPattern),
                    Filters.regex("usuarioAutor.nombreCompleto", regexPattern)
            );

            Bson orden = Sorts.orderBy(Sorts.ascending("tipo"), Sorts.descending("fechaHoraCreacion"));

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

    /**
     * Busca un post en la base de datos utilizando su ID.
     *
     * @param postId el ID del post a buscar
     * @return el post encontrado o null si no se encuentra ningún post con el
     * ID especificado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * búsqueda del post
     */
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

    /**
     * Busca todos los posts en la base de datos.
     *
     * @return una lista de todos los posts en la base de datos
     * @throws PersistenciaException si ocurre un error durante la operación de
     * búsqueda de los posts
     */
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
