/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaces.IPostDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hired.objetosNegocio.Post;
import org.hired.objetosNegocio.Usuario;

/**
 *
 * @author xeron
 */
public class PostDAO implements IPostDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hired_FindanySubAccesoDatos_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Constructor por defecto de la clase PostDAO.
     */
    public PostDAO() {
    }

    /**
     * Método para consultar usuarios
     *
     * @param usuario usuario del cual se quieren consultar los posts.
     * @return lista de posts por usuario.
     */
    public List<Post> consultarPost(Usuario usuario) {
        try {
            em.getTransaction().begin();
            TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p WHERE p.usuario = :usuario", Post.class);
            query.setParameter("usuario", usuario);
            List<Post> posts = query.getResultList();
            em.getTransaction().commit();
            return posts;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Método para consultar un post por su título.
     *
     * @param titulo título del post.
     * @return post encontrado.
     */
    public Post consultarPostTitulo(String titulo) {
        try {
            em.getTransaction().begin();
            TypedQuery<Post> query = em.createQuery("SELECT p FROM Post p WHERE p.titulo = :titulo", Post.class);
            query.setParameter("titulo", titulo);
            Post post = query.getSingleResult();
            em.getTransaction().commit();
            return post;
        } catch (NoResultException ex) {
            return null; // 
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Método usado para crear un post.
     *
     * @param post post a publicar.
     */
    public void crearPost(Post post) {
        try {
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    /**
     * Método usado para editar un post.
     *
     * @param post
     */
    public void editarPost(Post post) {
        try {
            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

}
