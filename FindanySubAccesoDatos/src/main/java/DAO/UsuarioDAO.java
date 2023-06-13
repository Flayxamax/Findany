/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaces.IUsuarioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hired.objetosNegocio.Estado;
import org.hired.objetosNegocio.Municipio;
import org.hired.objetosNegocio.Usuario;

/**
 *
 * @author ildex
 */
public class UsuarioDAO implements IUsuarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hired_FindanySubAccesoDatos_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Ingresa un nuevo usuario en la base de datos, asociado a un municipio y
     * estado.
     *
     * @param usuario Usuario a ingresar.
     * @param municipio Municipio al que pertenece el usuario.
     * @param estado Estado al que pertenece el municipio.
     */
    @Override
    public void ingresarUsuario(Usuario usuario, Municipio municipio, Estado estado) {
        try {
            em.getTransaction().begin();
            municipio.setEstado(estado);
            usuario.setMunicipio(municipio);
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param usuario Usuario a actualizar.
     */
    @Override
    public void actualizarUsuario(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Busca usuarios en la base de datos por su nombre completo.
     *
     * @param nombre El nombre completo del usuario a buscar.
     * @return Una lista de usuarios que coinciden con el nombre especificado.
     */
    @Override
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        try {
            TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.nombreCompleto = :nombre", Usuario.class);
            query.setParameter("nombre", nombre);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
