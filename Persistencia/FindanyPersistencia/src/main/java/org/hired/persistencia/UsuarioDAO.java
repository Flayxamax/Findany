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
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.interfaces.IUsuarioDAO;

/**
 * Esta clase implementa la interfaz IUsuarioDAO y proporciona métodos para
 * acceder y manipular los datos de los usuarios en la base de datos. Utiliza la
 * base de datos MongoDB para almacenar los datos de los usuarios. La clase
 * utiliza el patrón Singleton para garantizar una única instancia de la clase.
 *
 * @see IUsuarioDAO
 * @see FactoryPersistencia
 * @see Usuario
 * @see Municipio
 * @see ObjectId
 * @throws PersistenciaException si ocurre algún error en la interacción con la
 * base de datos
 * @throws NoSuchAlgorithmException si ocurre un error al encriptar la
 * contraseña utilizando el algoritmo SHA-256
 * @throws MongoException si ocurre un error en la operación con la base de
 * datos MongoDB
 * @throws MessageDigestException si ocurre un error al crear la instancia de
 * MessageDigest para el algoritmo SHA-256
 * @throws MongoException si ocurre un error en la operación con la base de
 * datos MongoDB
 * @throws PersistenciaException si ocurre algún error en la interacción con la
 * base de datos
 * @author Findany
 */
public class UsuarioDAO implements IUsuarioDAO {

    private static UsuarioDAO instancia;
    private final String NOMBRE_COLECCION = "User";

    /**
     * Crea una nueva instancia de UsuarioDAO.
     */
    public UsuarioDAO() {

    }

    /**
     * Obtiene la instancia única de UsuarioDAO utilizando el patrón Singleton.
     *
     * @return la instancia única de UsuarioDAO
     */
    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario el usuario a registrar
     * @return el usuario registrado
     * @throws PersistenciaException si el correo electrónico ya está registrado
     * en la base de datos o si ocurre un error durante la operación de registro
     * del usuario
     */
    @Override
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException {
        if (existeCorreoRegistrado(usuario.getCorreo())) {
            throw new PersistenciaException("El correo electrónico ya se encuentra registrado en el sistema");
        }

        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            usuario.setContrasena(encriptarContrasenia(usuario.getContrasena()));
            coleccion.insertOne(usuario);
            return usuario;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al registrar usuario: " + e.getLocalizedMessage());
        }
    }

    /**
     * Verifica si el correo electrónico ya está registrado en la base de datos.
     *
     * @param correo el correo electrónico a verificar
     * @return true si el correo electrónico está registrado, false en caso
     * contrario
     * @throws PersistenciaException si ocurre un error durante la operación de
     * verificación del correo electrónico
     */
    @Override
    public boolean existeCorreoRegistrado(String correo) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            Bson filtro = Filters.eq("correo", correo);
            return coleccion.countDocuments(filtro) > 0;
        } catch (MongoException e) {
            throw new PersistenciaException("Error al verificar el correo electrónico: " + e.getLocalizedMessage());
        }
    }

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param usuario el usuario a actualizar
     * @throws PersistenciaException si ocurre un error durante la operación de
     * actualización del usuario
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            Bson filtro = eq("_id", usuario.getId());

            Usuario usuarioActual = coleccion.find(filtro).first();
            if (usuarioActual == null) {
                throw new PersistenciaException("El usuario no existe en la base de datos");
            }

            String correoActual = usuarioActual.getCorreo();
            String nuevoCorreo = usuario.getCorreo();
            if (!correoActual.equals(nuevoCorreo)) {
                if (existeCorreoRegistrado(nuevoCorreo)) {
                    throw new PersistenciaException("El correo electrónico ya se encuentra registrado en el sistema");
                }
            }
            usuario.setContrasena(encriptarContrasenia(usuario.getContrasena()));

            Document documentoActualizacion = new Document("$set", new Document()
                    .append("nombreCompleto", usuario.getNombreCompleto())
                    .append("correo", usuario.getCorreo())
                    .append("telefono", usuario.getTelefono())
                    .append("contrasena", usuario.getContrasena())
                    .append("genero", usuario.getGenero().toString())
                    .append("ciudad", usuario.getCiudad())
                    .append("municipio", usuario.getMunicipio())
                    .append("tipo", usuario.getTipo())
                    .append("avatar", usuario.getAvatar())
            );
            coleccion.updateOne(filtro, documentoActualizacion);
        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar el usuario: " + e.getLocalizedMessage());
        }
    }

    /**
     * Encripta una contraseña utilizando el algoritmo de hash SHA-256.
     *
     * @param contrasenia la contraseña a encriptar
     * @return la contraseña encriptada
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

    /**
     * Autentifica un usuario utilizando el correo y la contraseña
     * proporcionados.
     *
     * @param correo el correo del usuario
     * @param contrasena la contraseña del usuario
     * @return true si la autenticación es exitosa, false de lo contrario
     * @throws PersistenciaException si ocurre un error durante la operación de
     * autenticación del usuario
     */
    @Override
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

    /**
     * Busca un usuario en la base de datos utilizando el correo electrónico.
     *
     * @param correo el correo electrónico del usuario a buscar
     * @return el usuario encontrado o null si no se encuentra ningún usuario
     * con el correo electrónico especificado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * búsqueda del usuario
     */
    @Override
    public Usuario buscarUsuarioPorCorreo(String correo) throws PersistenciaException {
        try {
            MongoCollection<Usuario> coleccion = ConexionMongoDB.getInstancia().getBaseDatos().getCollection(NOMBRE_COLECCION, Usuario.class);
            Bson filtro = eq("correo", correo);
            return coleccion.find(filtro).first();
        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar el usuario: " + e.getMessage());
        }
    }

}
