/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.hired.persistencia;

import org.hired.interfaces.IComentarioDAO;
import org.hired.interfaces.IEstadoDAO;
import org.hired.interfaces.IMunicipioDAO;
import org.hired.interfaces.IPostDAO;
import org.hired.interfaces.IUsuarioDAO;

/**
 * La clase FactoryPersistencia es una fábrica que proporciona instancias de los
 * diferentes DAO (Data Access Object) utilizados para acceder a la persistencia
 * de datos. Contiene métodos estáticos para obtener instancias de los DAO de
 * usuario, estado, municipio y comentario.
 *
 * @see IUsuarioDAO
 * @see IEstadoDAO
 * @see IMunicipioDAO
 * @see IComentarioDAO
 * @see UsuarioDAO
 * @see EstadoDAO
 * @see MunicipioDAO
 * @see ComentarioDAO
 * @author HIRED
 */
public class FactoryPersistencia {

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    public FactoryPersistencia() {
    }

    /**
     * Obtiene una instancia del DAO de usuario.
     *
     * @return una instancia del DAO de usuario
     */
    public static IUsuarioDAO getUsuarioDAO() {
        return UsuarioDAO.getInstancia();
    }

    /**
     * Obtiene una instancia del DAO de estado.
     *
     * @return una instancia del DAO de estado
     */
    public static IEstadoDAO getEstadoDAO() {
        return EstadoDAO.getInstancia();
    }

    /**
     * Obtiene una instancia del DAO de municipio.
     *
     * @return una instancia del DAO de municipio
     */
    public static IMunicipioDAO getMunicipioDAO() {
        return MunicipioDAO.getInstancia();
    }

    /**
     * Obtiene una instancia del DAO de comentario.
     *
     * @return una instancia del DAO de comentario
     */
    public static IComentarioDAO getComentarioDAO() {
        return ComentarioDAO.getInstancia();
    }
    
    public static IPostDAO getPostDAO(){
        return PostDAO.getInstancia();
    }
}
