/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.hired.findanyappweb;

import java.util.Date;
import org.hired.dominio.Estado;
import org.hired.dominio.Genero;
import org.hired.dominio.Municipio;
import org.hired.dominio.Usuario;
import org.hired.exception.PersistenciaException;
import org.hired.interfaces.IUsuarioDAO;
import org.hired.persistencia.ConexionMongoDB;
import org.hired.persistencia.UsuarioDAO;

/**
 *
 * @author ildex
 */
public class FindanyAppWeb {

    public static void main(String[] args) throws PersistenciaException {
        //Pruebas mongo
        Date fechaNacimiento = new Date(1969 - 1901, 4, 20);
        Usuario usuario1 = new Usuario("Jonathan Tilin", "tilin@a.com", "qwerty", "6442345678", "a", "Cd. obregón", fechaNacimiento, Genero.MASCULINO);
        Municipio municipio = new Municipio("Vicam");
        Estado estado = new Estado("Sinaloa");

        ConexionMongoDB conexion = new ConexionMongoDB();
        IUsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
//        usuarioDAO.registrarUsuario(usuario1, municipio, estado);
        
//        usuarioDAO.actualizarUsuario(usuario1, municipio, estado);
        
        
        String correo = "tilin@a.com";
        String contrasena = "qwerty";
        if (usuarioDAO.autentificarUsuario(correo, contrasena)) {
            System.out.println("Te logeaste");
        }else{
            System.out.println("No");
        }
    }
}
