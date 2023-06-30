/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import java.util.List;
import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.IComentarioDAO;
import org.hired.interfaces.IEstadoDAO;
import org.hired.interfaces.IMunicipioDAO;
import org.hired.interfaces.IUsuarioDAO;

/**
 * Esta clase actúa como una fachada para la persistencia de datos,
 * proporcionando métodos convenientes para interactuar con los diferentes DAO
 * (objetos de acceso a datos). Combina la funcionalidad de los DAO de Usuario,
 * Estado, Municipio y Comentario. Utiliza la fábrica de persistencia
 * (FactoryPersistencia) para obtener instancias de los DAO correspondientes.
 *
 * @author Findany
 */
public class FacadePersistencia {

    private final IUsuarioDAO usuarioDAO;
    private final IEstadoDAO estadoDAO;
    private final IMunicipioDAO municipioDAO;
    private final IComentarioDAO comentarioDAO;

    /**
     * Crea una nueva instancia de FacadePersistencia y obtiene las instancias
     * de los DAO correspondientes utilizando la fábrica de persistencia.
     */
    public FacadePersistencia() {
        this.usuarioDAO = FactoryPersistencia.getUsuarioDAO();
        this.estadoDAO = FactoryPersistencia.getEstadoDAO();
        this.municipioDAO = FactoryPersistencia.getMunicipioDAO();
        this.comentarioDAO = FactoryPersistencia.getComentarioDAO();
    }

    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException {
        return this.usuarioDAO.registrarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuario, Municipio municipio, ObjectId estado) throws PersistenciaException {
        this.usuarioDAO.actualizarUsuario(usuario, municipio, estado);
    }

    public boolean autentificarUsuario(String correo, String contrasena) throws PersistenciaException {
        return this.usuarioDAO.autentificarUsuario(correo, contrasena);
    }

    public Usuario buscarUsuarioPorCorreo(String correo) throws PersistenciaException {
        return this.usuarioDAO.buscarUsuarioPorCorreo(correo);
    }

    public List<Estado> obtenerEstados() throws PersistenciaException {
        return this.estadoDAO.obtenerEstados();
    }

    public List<Municipio> obtenerMunicipiosPorEstado() throws PersistenciaException {
        return this.municipioDAO.obtenerMunicipiosPorEstado();
    }

    public Comentario crearComentario(Comentario comentario) throws PersistenciaException {
        return this.comentarioDAO.crearComentario(comentario);
    }

    public Comentario crearComentarioRespuesta(Comentario comentario) throws PersistenciaException {
        return this.comentarioDAO.crearComentarioRespuesta(comentario);
    }

    public List<Comentario> obtenerComentarios() throws PersistenciaException {
        return this.comentarioDAO.obtenerComentarios();
    }
}
