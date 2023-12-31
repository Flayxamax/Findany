/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.findanyobjetosnegocio.Genero;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.TipoUsuario;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.ActualizarUsuarioBO;
import org.hired.impl.CrearUsuarioBO;
import org.hired.impl.EstadoBO;
import org.hired.impl.MunicipioBO;
import org.hired.impl.ViewUserBO;
import org.hired.interfaces.IActualizarUsuarioBO;
import org.hired.interfaces.ICrearUsuarioBO;
import org.hired.interfaces.IEstadoBO;
import org.hired.interfaces.IMunicipioBO;
import org.hired.interfaces.IViewUserBO;
import org.hired.utils.Validadores;

/**
 *
 * @author ildex
 */
@WebServlet(name = "EditUserServlet", urlPatterns = {"/edit-user"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 10, // 10 KB
        maxFileSize = 1024 * 1024 * 16, // 16 MB
        maxRequestSize = 1024 * 1024 * 16 // 16 MB
)
public class EditUserServlet extends HttpServlet {

    private Validadores validador = new Validadores();

    protected void processObtenerEstadosMunicipios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IEstadoBO estadoBO = new EstadoBO();
        IMunicipioBO municipioBO = new MunicipioBO();
        try {
            List<Estado> estados = estadoBO.consultarEstados();
            request.setAttribute("estados", estados);
            List<Municipio> municipios = municipioBO.consultarMunicipiosPorEstado();
            request.setAttribute("municipios", municipios);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("error/errorJava.jsp").forward(request, response);
        }
        String paginaDestino = "/view-user-edit.jsp";
        getServletContext().getRequestDispatcher(paginaDestino).forward(request, response);
    }

    protected Usuario obtenerDatosFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener parámetros del formulario
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String tel = request.getParameter("tel");
            String contrasena = request.getParameter("pass");
            String genero = request.getParameter("genero");
            String ciudad = request.getParameter("ciudad");
            String estado = request.getParameter("estado");
            String municipio = request.getParameter("municipio");
            Part imagenPart = request.getPart("imagen");

            if (nombre == null || nombre.isBlank() || !validador.esNombre(nombre)) {
                throw new IllegalArgumentException("El nombre es inválido");
            }
            if (correo == null || correo.isBlank() || !validador.esCorreo(correo)) {
                throw new IllegalArgumentException("El correo es inválido");
            }
            if (tel == null || tel.isBlank() || !validador.esTelefono(tel)) {
                throw new IllegalArgumentException("El teléfono es inválido");
            }
            if (contrasena == null || contrasena.isBlank() || !validador.esContrasena(contrasena)) {
                throw new IllegalArgumentException("La contraseña es inválida");
            }
            if (genero == null || genero.isBlank()) {
                throw new IllegalArgumentException("El género es inválido");
            }
            if (ciudad == null || ciudad.isBlank() || !validador.esCiudad(ciudad)) {
                throw new IllegalArgumentException("La ciudad es inválida");
            }
            if (estado == null || estado.isBlank()) {
                throw new IllegalArgumentException("El estado es inválido");
            }
            if (municipio == null || municipio.isBlank()) {
                throw new IllegalArgumentException("El municipio es inválido");
            }

            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("usuario") != null) {
                Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario");
                ObjectId idUsuario = usuarioLogueado.getId();

                Usuario usuario = new Usuario();
                usuario.setId(idUsuario);
                usuario.setNombreCompleto(nombre);
                usuario.setCorreo(correo);
                usuario.setTelefono(tel);
                usuario.setContrasena(contrasena);
                if (genero.equals("masculino")) {
                    usuario.setGenero(Genero.MASCULINO);
                } else {
                    usuario.setGenero(Genero.FEMENINO);
                }
                if (usuarioLogueado.getTipo().toString().equals("ADMINISTRADOR")) {
                    usuario.setTipo(TipoUsuario.ADMINISTRADOR);
                } else {
                    usuario.setTipo(TipoUsuario.NORMAL);
                }
                usuario.setCiudad(ciudad);
                Municipio municipioA = new Municipio(municipio);
                usuario.setMunicipio(municipioA);

                if (imagenPart != null) {
                    InputStream imagenInputStream = imagenPart.getInputStream();
                    byte[] imagenBytes = IOUtils.toByteArray(imagenInputStream);
                    usuario.setAvatar(new Binary(imagenBytes));
                } else if (imagenPart == null) {
                    Binary imagenBinary = usuario.getAvatar();
                    byte[] imagenBytes = imagenBinary.getData();
                    usuario.setAvatar(new Binary(imagenBytes));
                }

                return usuario;
            } else {
                throw new IllegalArgumentException("El usuario no ha iniciado sesión");
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Error en los datos del formulario: " + e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorHttp.jsp").forward(request, response);
        }

        return null;
    }

    protected void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = this.obtenerDatosFormulario(request, response);

        //APLICAR LOGICA DE NEGOCIO
        IActualizarUsuarioBO actualizarUsuarioBO = new ActualizarUsuarioBO();
        try {
            actualizarUsuarioBO.modificarUsuario(usuario);
            HttpSession session = request.getSession();
            Usuario usuarioS = (Usuario) session.getAttribute("usuario");
            usuarioS.setNombreCompleto(usuario.getNombreCompleto());
            usuarioS.setCorreo(usuario.getCorreo());
            usuarioS.setTelefono(usuario.getTelefono());
            usuarioS.setGenero(usuario.getGenero());
            usuarioS.setCiudad(usuario.getCiudad());
            usuarioS.setMunicipio(usuario.getMunicipio());
            usuarioS.setAvatar(usuario.getAvatar());
            usuarioS.setTipo(usuario.getTipo());
            session.setAttribute("usuario", usuarioS);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }

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
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null || action.equalsIgnoreCase("obtener-estados")) {
            this.processObtenerEstadosMunicipios(request, response);
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
        request.setCharacterEncoding("UTF-8");
        this.processUpdate(request, response);
        return;
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
