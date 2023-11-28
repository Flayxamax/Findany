/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.AccessDeniedException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.hired.dtos.CrearPostDTO;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Post;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.LoginUsuarioBO;
import org.hired.impl.PostBO;
import org.hired.interfaces.ILoginUsuarioBO;
import org.hired.interfaces.IPostBO;
import org.hired.utils.ObjectIdTypeAdapter;
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
        if (action != null && action.equalsIgnoreCase("post")) {
            this.processObtenerPost(request, response);
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
        }
        if (action != null && action.equalsIgnoreCase("update")) {
            this.processUpdate(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("search")) {
            this.processBuscarPost(request, response);
            return;
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

            if (crearPostDTO.getTitulo() == null || crearPostDTO.getTitulo().isBlank() || !validador.esTitulo(crearPostDTO.getTitulo())) {
                throw new IllegalArgumentException("El título es inválido");
            }
            if (crearPostDTO.getContenido() == null || crearPostDTO.getContenido().isBlank() || !validador.esContenido(crearPostDTO.getContenido())) {
                throw new IllegalArgumentException("El contenido es inválido");
            }

            Post post = new Post();
            post.setTitulo(crearPostDTO.getTitulo());
            post.setContenido(crearPostDTO.getContenido());
            post.setTipo(crearPostDTO.getTipo());

            ILoginUsuarioBO usuarioBO = new LoginUsuarioBO();
            HttpSession session = request.getSession();
            Enumeration<String> attributeNames = session.getAttributeNames();
            String attributeName = attributeNames.nextElement();
            Usuario usuario = (Usuario) session.getAttribute(attributeName);

            if (usuario != null) {
                usuario = usuarioBO.busquedaUsuario(usuario.getCorreo());

                post.setUsuarioAutor(usuario);
                post.setFechaHoraCreacion(crearPostDTO.getFechaHoraCreacion());

                IPostBO postBO = new PostBO();
                Post postGuardado = postBO.crearPost(post);
                out.println(serializadorJSON.toJson(postGuardado));
            } else {
                throw new AccessDeniedException("No se encontro usuario con sesión");
            }
        } catch (IllegalArgumentException ex) {
            response.setStatus(400);//BAD_REQUEST
            out.println(serializadorJSON.toJson(ex.getMessage()));
        } catch (JsonSyntaxException | IOException | NegocioException ex) {
            response.setStatus(500);    // ERROR EN EL SERVER
            out.println(serializadorJSON.toJson("Fallo interno del servidor: " + ex.getMessage()));
        }
    }
    
    protected void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson serializadorJSON = new Gson();
        try {
            String datosJSON = IOUtils.toString(request.getInputStream(), "utf-8");
            CrearPostDTO crearPostDTO = serializadorJSON.fromJson(datosJSON, CrearPostDTO.class);

            if (crearPostDTO.getTitulo() == null || crearPostDTO.getTitulo().isBlank() || !validador.esTitulo(crearPostDTO.getTitulo())) {
                throw new IllegalArgumentException("El título es inválido");
            }
            if (crearPostDTO.getContenido() == null || crearPostDTO.getContenido().isBlank() || !validador.esContenido(crearPostDTO.getContenido())) {
                throw new IllegalArgumentException("El contenido es inválido");
            }

            Post post = new Post();
            post.setId(crearPostDTO.getId());
            post.setTitulo(crearPostDTO.getTitulo());
            post.setContenido(crearPostDTO.getContenido());
            post.setTipo(crearPostDTO.getTipo());
            post.setFechaHoraCreacion(crearPostDTO.getFechaHoraCreacion());
            post.setFechaHoraEdicion(crearPostDTO.getFechaHoraEdicion());

            ILoginUsuarioBO usuarioBO = new LoginUsuarioBO();
            HttpSession session = request.getSession();
            Enumeration<String> attributeNames = session.getAttributeNames();
            String attributeName = attributeNames.nextElement();
            Usuario usuario = (Usuario) session.getAttribute(attributeName);

            if (usuario != null) {
                usuario = usuarioBO.busquedaUsuario(usuario.getCorreo());

                post.setUsuarioAutor(usuario);
                post.setFechaHoraCreacion(crearPostDTO.getFechaHoraCreacion());

                IPostBO postBO = new PostBO();
                Post postGuardado = postBO.actualizarPost(post);
                out.println(serializadorJSON.toJson(postGuardado));
            } else {
                throw new AccessDeniedException("No se encontro usuario con sesión");
            }
        } catch (IllegalArgumentException ex) {
            response.setStatus(400);//BAD_REQUEST
            out.println(serializadorJSON.toJson(ex.getMessage()));
        } catch (JsonSyntaxException | IOException | NegocioException ex) {
            response.setStatus(500);    // ERROR EN EL SERVER
            out.println(serializadorJSON.toJson("Fallo interno del servidor"));
        }
    }

    protected void processObtener(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IPostBO postBO = new PostBO();
            List<Post> listaPost = postBO.buscarTodo();

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter());
            Gson serializadorJSON = gsonBuilder.create();

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

    protected void processObtenerPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            IPostBO postBO = new PostBO();
            Post post = postBO.buscarPorId(id);
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter());
            Gson serializadorJSON = gsonBuilder.create();
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson(post));
            }
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/view-post.jsp").forward(request, response);
    }

    private void processBuscarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdapter());
        Gson serializadorJSON = gsonBuilder.create();
        
        try (BufferedReader reader = request.getReader()) {
            String datosJSON = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            Map<String, String> jsonMap = serializadorJSON.fromJson(datosJSON, new TypeToken<Map<String, String>>() {
            }.getType());
            String termino = jsonMap.get("termino");
            IPostBO postBO = new PostBO();
            List<Post> listaPost = postBO.buscarPost(termino);

            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println(serializadorJSON.toJson(listaPost));
            }
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
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
