/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bson.conversions.Bson;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.IUsuarioDAO;

/**
 *
 * @author ildex
 */
public class UsuarioDAO implements IUsuarioDAO {

    private static UsuarioDAO instancia;
    private final String NOMBRE_COLECCION = "user";

    public UsuarioDAO() {

    }

    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    @Override
    public void registrarUsuario(Usuario usuario, Municipio municipio, Estado estado) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            usuario.setContrasena(encriptarContrasenia(usuario.getContrasena()));
            usuario.setMunicipio(municipio);
            municipio.setEstado(estado);
            coleccion.insertOne(usuario);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al registrar usuario: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario, Municipio municipio, Estado estado) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            Bson filtro = eq("_id", usuario.getId());
            coleccion.replaceOne(filtro, usuario);

            Bson actualizacionMunicipio = set("municipio", municipio);
            coleccion.updateOne(filtro, actualizacionMunicipio);

            Bson actualizacionEstado = set("estado", estado);
            coleccion.updateOne(filtro, actualizacionEstado);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar el usuario: " + e.getLocalizedMessage());
        }
    }

    /**
     * Encripta una contraseña utilizando el algoritmo de hash SHA-256.
     *
     * @param contrasenia La contraseña a encriptar.
     * @return La contraseña encriptada.
     */
    public String encriptarContrasenia(String contrasenia) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(contrasenia.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }

        return null;
    }

    public boolean autentificarUsuario(String correo, String contrasena) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            Bson filtro = Filters.and(Filters.eq("correo", correo), Filters.eq("contrasena", encriptarContrasenia(contrasena)));
            Usuario usuario = coleccion.find(filtro).first();
            return usuario != null;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al autentificar usuario: " + e.getLocalizedMessage());
        }
    }

}