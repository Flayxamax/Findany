/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.hired.objetosNegocio.Post;
import org.hired.objetosNegocio.Usuario;

/**
 *
 * @author xeron
 */
public interface IPostDAO {
    
     public List<Post> consultarPost(Usuario usuario);
     
     public Post consultarPostTitulo(String titulo);
     
     public void crearPost(Post post);
     
     public void editarPost(Post post);
}
