/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.ComentarioBO;
import org.hired.impl.LoginUsuarioBO;
import org.hired.interfaces.IComentarioBO;
import org.hired.interfaces.ILoginUsuarioBO;
import org.hired.utils.Validadores;

/**
 *
 * @author HIRED
 */
@WebServlet(name = "CommentServlet", urlPatterns = {"/comment"})
public class CommentServlet extends HttpServlet {

    private Validadores validador = new Validadores();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CommentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processObtener(request, response);
        } catch (NegocioException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processObtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        try {
            IComentarioBO comentarioBO = new ComentarioBO();
            List<Comentario> listaComentarios = comentarioBO.obtenerComentarios();
            request.setAttribute("comentarios", listaComentarios);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
        //getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }

    protected void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        Comentario comentario = obtenerDatos(request, response);
        IComentarioBO comentarioBO = new ComentarioBO();
        try {
            Comentario comentarioGuardado = comentarioBO.crearComentario(comentario);
            request.setAttribute("comentario", comentarioGuardado);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
            return;
        }
        doGet(request, response);
    }

    protected Comentario obtenerDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        try {
            String contenido = request.getParameter("contenido");
            String comentarioPadreId = request.getParameter("comentarioPadre");

            if (contenido == null || contenido.isBlank() || !validador.esContenidoComentario(contenido)) {
                throw new IllegalArgumentException("El contenido es inválido");
            }

            Comentario comentario = new Comentario();
            comentario.setContenido(contenido);

            HttpSession session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            String correo = usuario.getCorreo();

            ILoginUsuarioBO usuarioBO = new LoginUsuarioBO();
            Usuario usuario2 = usuarioBO.busquedaUsuario(correo);
            comentario.setUsuarioAutor(usuario2);
            comentario.setFechaHora(new Date());

            if (comentarioPadreId == null || comentarioPadreId.isBlank()) {
                // Es un comentario padre
                return comentario;
            } else {
                // Es una respuesta a un comentario padre
                ObjectId comentarioPadre = new ObjectId(comentarioPadreId);
                comentario.setComentarioPadre(comentarioPadre);
                return comentario;
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Error en los datos del formulario: " + e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorHttp.jsp").forward(request, response);
            return null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("create")) {
            try {
                processCreate(request, response);
            } catch (NegocioException ex) {
                Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
