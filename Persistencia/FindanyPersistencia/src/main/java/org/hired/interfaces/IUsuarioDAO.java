/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.hired.interfaces;

import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Usuario;

/**
 * La interfaz {@code IUsuarioDAO} define los métodos para acceder y manipular
 * la persistencia de los usuarios en la base de datos. Proporciona operaciones
 * como registrar un usuario, verificar la existencia de un correo electrónico,
 * actualizar la información de un usuario, autentificar un usuario y buscar un
 * usuario por su correo electrónico.
 *
 * Todos los métodos de esta interfaz pueden lanzar una excepción de tipo
 * PersistenciaException si ocurre algún error durante la operación de
 * persistencia.
 *
 */
public interface IUsuarioDAO {

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario el usuario a registrar
     * @return el usuario registrado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * registro del usuario
     */
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException;

    /**
     * Verifica si un correo electrónico ya está registrado en la base de datos.
     *
     * @param correo el correo electrónico a verificar
     * @return true si el correo electrónico está registrado, false en caso
     * contrario
     * @throws PersistenciaException si ocurre un error durante la operación de
     * verificación del correo electrónico
     */
    public boolean existeCorreoRegistrado(String correo) throws PersistenciaException;

    /**
     * Actualiza la información de un usuario en la base de datos.
     *
     * @param usuario el usuario a actualizar
     * @throws PersistenciaException si ocurre un error durante la operación de
     * actualización del usuario
     */
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException;

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
    public boolean autentificarUsuario(String correo, String contrasena) throws PersistenciaException;

    /**
     * Busca un usuario en la base de datos utilizando el correo electrónico.
     *
     * @param correo el correo electrónico del usuario a buscar
     * @return el usuario encontrado o null si no se encuentra ningún usuario
     * con el correo electrónico especificado
     * @throws PersistenciaException si ocurre un error durante la operación de
     * búsqueda del usuario
     */
    public Usuario buscarUsuarioPorCorreo(String correo) throws PersistenciaException;
}
