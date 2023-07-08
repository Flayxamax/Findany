/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.hired.dtos.CrearPostDTO;
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
        if (action != null && action.equalsIgnoreCase("create")) {
            processCreate(request, response);
        } else {
            doGet(request, response);
        }
    }

    protected void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson serializadorJSON = new Gson();
        try {
            String datosJSON = IOUtils.toString(request.getInputStream(), "utf-8");
            CrearPostDTO crearPostDTO = serializadorJSON.fromJson(datosJSON, CrearPostDTO.class);

            // VALIDACIONES DE DATOS...
            if (crearPostDTO.getTitulo() == null || crearPostDTO.getTitulo().isBlank() || !validador.esTitulo(crearPostDTO.getTitulo())) {
                throw new IllegalArgumentException("El título es inválido");
            }
            if (crearPostDTO.getContenido() == null || crearPostDTO.getContenido().isBlank() || !validador.esContenido(crearPostDTO.getContenido())) {
                throw new IllegalArgumentException("El contenido es inválido");
            }

            Post post = new Post();
            post.setTitulo(crearPostDTO.getTitulo());
            post.setContenido(crearPostDTO.getContenido());
            if ("on".equals(crearPostDTO.getTipo())) {
                post.setTipo(TipoPost.ANCLADO);
            } else {
                post.setTipo(TipoPost.COMUN);
            }

            ILoginUsuarioBO usuarioBO = new LoginUsuarioBO();
            String correo = null;
            HttpSession session = request.getSession();
            if (session.getAttribute("usuario") != null) {
                correo = (String) session.getAttribute("usuario.correo");
            }

            if (correo != null) {
                Usuario usuario = usuarioBO.busquedaUsuario(correo);

                post.setUsuarioAutor(usuario);
                post.setFechaHoraCreacion(new Date());
            }

            IPostBO postBO = new PostBO();
            Post postGuardado = postBO.crearPost(post);
            out.println(serializadorJSON.toJson(postGuardado));
        } catch (IllegalArgumentException ex) {
            response.setStatus(400); // BAD_REQUEST
            out.println(serializadorJSON.toJson(ex.getMessage()));
        } catch (Exception ex) {
            response.setStatus(500); // ERROR EN EL SERVIDOR
            out.println(serializadorJSON.toJson("Error interno del servidor"));
        }
    }

    protected void processObtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IPostBO postBO = new PostBO();
            List<Post> listaPost = postBO.buscarTodo();
            Gson serializadorJSON = new Gson();
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson(listaPost));
            }
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
