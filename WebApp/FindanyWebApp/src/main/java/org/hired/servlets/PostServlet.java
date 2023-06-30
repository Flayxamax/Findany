/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Post;
import org.hired.findanyobjetosnegocio.TipoPost;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.LoginUsuarioBO;
import org.hired.impl.PostBO;
import org.hired.interfaces.ILoginUsuarioBO;
import org.hired.interfaces.IPostBO;
import org.hired.utils.Validadores;

/**
 *
 * @author wikit
 */
@WebServlet(name = "PostServlet", urlPatterns = {"/post"})
public class PostServlet extends HttpServlet {

    private Validadores validador = new Validadores();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equalsIgnoreCase("feed")) {
            this.processObtener(request, response);
            return;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null && action.equalsIgnoreCase("create")) {
            try {
                this.processCreate(request, response);
                return;
            } catch (ParseException ex) {
                Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NegocioException ex) {
                Logger.getLogger(PostServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }

    }

    protected Post obtenerDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        try {
            // Obtener parámetros del formulario
            String titulo = request.getParameter("titulo");
            String contenido = request.getParameter("contenido");
            String anclado = request.getParameter("anclado");

            if (titulo == null || titulo.isBlank() || !validador.esTitulo(titulo)) {
                throw new IllegalArgumentException("El titulo es inválido");
            }
            if (contenido == null || contenido.isBlank() || !validador.esContenido(contenido)) {
                throw new IllegalArgumentException("El contenido es inválido");
            }
            if (anclado == null || anclado.isBlank()) {
                throw new IllegalArgumentException("El anclado es inválido");
            }

            Post post = new Post();
            post.setTitulo(titulo);
            post.setContenido(contenido);
            if ("on".equals(anclado)) {
                post.setTipo(TipoPost.ANCLADO);
            } else {
                post.setTipo(TipoPost.COMUN);
            }
            ILoginUsuarioBO usuarioBO = new LoginUsuarioBO();
            String correo = (String) (request.getSession().getAttribute("usuario.correo"));
            Usuario usuario = usuarioBO.busquedaUsuario(correo);

            post.setUsuarioAutor(usuario);
            post.setFechaHoraCreacion(new Date());

            return post;
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Error en los datos del formulario: " + e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorHttp.jsp").forward(request, response);
        }

        return null;
    }

    protected void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, NegocioException {
        Post post = this.obtenerDatos(request, response);

        System.out.println("NEGRO");
        IPostBO postBO = new PostBO();
        try {
            Post postGuardado = postBO.crearPost(post);
            request.setAttribute("post", postGuardado);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }

    protected void processObtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IPostBO postBO = new PostBO();
            List<Post> listaPost = postBO.buscarTodo();
            request.setAttribute("posts", listaPost);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
