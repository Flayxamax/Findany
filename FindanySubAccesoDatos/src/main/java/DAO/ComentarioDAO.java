/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaces.IComentarioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.hired.objetosNegocio.Comentario;
import org.hired.objetosNegocio.Post;

/**
 *
 * @author wikit
 */
public class ComentarioDAO implements IComentarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hired_FindanySubAccesoDatos_jar_1.0-SNAPSHOTPU");
    private final EntityManager entityManager = emf.createEntityManager();

    /**
     * Agrega un comentario a la base de datos.
     *
     * @param comentario el comentario a agregar
     * @throws PersistenceException si ocurre un error al agregar el comentario
     */
    @Override
    public void agregarComentario(Comentario comentario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(comentario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al agregar el comentario");
        }
    }

    /**
     * Elimina un comentario de la base de datos.
     *
     * @param comentario el comentario a eliminar
     * @throws PersistenceException si ocurre un error al eliminar el comentario
     */
    @Override
    public void eliminarComentario(Comentario comentario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(comentario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenceException("Error al eliminar el comentario");
        }
    }

    /**
     * Consulta todos los comentarios asociados a un post específico.
     *
     * @param post el post para el cual se desean consultar los comentarios
     * @return una lista de comentarios asociados al post
     */
    @Override
    public List<Comentario> consultarComentariosPorPost(Post post) {
        Query query = entityManager.createQuery("SELECT c FROM Comentario c WHERE c.post = :post");
        query.setParameter("post", post);
        return query.getResultList();
    }

    /**
     * Consulta todos los comentarios que son respuestas a un comentario
     * específico.
     *
     * @param comentario el comentario para el cual se desean consultar las
     * respuestas
     * @return una lista de comentarios que son respuestas al comentario dado
     */
    @Override
    public List<Comentario> consultarComentariosPorComentario(Comentario comentario) {
        Query query = entityManager.createQuery("SELECT c FROM Comentario c WHERE c.comentarioPadre = :comentario");
        query.setParameter("comentario", comentario);
        return query.getResultList();
    }

    /**
     * Consulta todos los comentarios almacenados en la base de datos.
     *
     * @return una lista de todos los comentarios almacenados
     */
    @Override
    public List<Comentario> consultarTodos() {
        Query query = entityManager.createQuery("SELECT a FROM Comentario a");
        return query.getResultList();
    }

}
