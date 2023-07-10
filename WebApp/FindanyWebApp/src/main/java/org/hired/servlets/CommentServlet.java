/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.hired.dtos.CrearComentarioDTO;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Comentario;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.ComentarioBO;
import org.hired.impl.LoginUsuarioBO;
import org.hired.interfaces.IComentarioBO;
import org.hired.interfaces.ILoginUsuarioBO;
import org.hired.utils.ObjectIdTypeAdapter;
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
        String action = request.getParameter("action");
        try {
            if (action == null || action.equalsIgnoreCase("respuesta")) {
                this.processObtenerRespuesta(request, response);
                return;
            } else if (action == null || action.equalsIgnoreCase("obtain")) {
                this.processObtener(request, response);
                return;

            }
        } catch (NegocioException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processObtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        try {
            IComentarioBO comentarioBO = new ComentarioBO();
            List<Comentario> listaComentarios = comentarioBO.obtenerComentarios();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter());
            Gson serializadorJSON = gsonBuilder.create();
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson(listaComentarios));
            }
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
        //getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }
    protected void processObtenerRespuesta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        try {
            String id = request.getParameter("id");
            if (id == null || id.isEmpty()) {
                // Si no se proporciona un ID, lanzar una excepción o manejar el caso en consecuencia
                throw new IllegalArgumentException("No se proporcionó un ID de comentario válido");
            }

            IComentarioBO comentarioBO = new ComentarioBO();
            Comentario comentario = comentarioBO.buscarComentarioPorId(id);

            // Verificar si se encontró el comentario
            if (comentario == null) {
                // Manejar el caso cuando el comentario no existe
                throw new NegocioException("El comentario no existe");
            }

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter());
            Gson serializadorJSON = gsonBuilder.create();
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson(comentario));
            }
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
    }

    protected void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        Gson serializadorJSON = new Gson();
        Comentario comentario = obtenerDatos(request, response);
        IComentarioBO comentarioBO = new ComentarioBO();
        try {
            Comentario comentarioGuardado = comentarioBO.crearComentario(comentario);
            out.println(serializadorJSON.toJson(comentarioGuardado));
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
            return;
        }
        doGet(request, response);
    }

    protected Comentario obtenerDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        response.setContentType("application/json;charset=UTF-8");
        Gson serializadorJSON = new Gson();
        try {
            String datosJSON = IOUtils.toString(request.getInputStream(), "utf-8");
            CrearComentarioDTO crearComentarioDTO = serializadorJSON.fromJson(datosJSON, CrearComentarioDTO.class);

            if (crearComentarioDTO.getContenido() == null || crearComentarioDTO.getContenido().isBlank() || !validador.esContenidoComentario(crearComentarioDTO.getContenido())) {
                throw new IllegalArgumentException("El contenido es inválido");
            }

            Comentario comentario = new Comentario();
            comentario.setContenido(crearComentarioDTO.getContenido());
            comentario.setFechaHora(crearComentarioDTO.getFechaHoraCreacion());

            String correo = crearComentarioDTO.getUsuarioAutor();

            ILoginUsuarioBO usuarioBO = new LoginUsuarioBO();
            Usuario usuario2 = usuarioBO.busquedaUsuario(correo);
            comentario.setUsuarioAutor(usuario2);

            if (crearComentarioDTO.getComentarioPadre() == null || crearComentarioDTO.getComentarioPadre().isBlank()) {
                // Es un comentario padre
                return comentario;
            } else {
                // Es una respuesta a un comentario padre
                String id = crearComentarioDTO.getComentarioPadre();
                IComentarioBO comentarioBO = new ComentarioBO();
                Comentario comentarioPadre = comentarioBO.buscarComentarioPorId(id);
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
