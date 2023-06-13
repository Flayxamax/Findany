/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.hired.objetosNegocio.Estado;
import org.hired.objetosNegocio.Municipio;
import org.hired.objetosNegocio.Usuario;

/**
 *
 * @author ildex
 */
public interface IUsuarioDAO {
    public void ingresarUsuario(Usuario usuario, Municipio municipio, Estado estado);
    public void actualizarUsuario(Usuario usuario);
    public List<Usuario> buscarUsuarioPorNombre(String nombre);
}
