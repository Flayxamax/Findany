/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.bson.types.Binary;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.findanyobjetosnegocio.Genero;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.CrearUsuarioBO;
import org.hired.impl.EstadoBO;
import org.hired.impl.MunicipioBO;
import org.hired.interfaces.ICrearUsuarioBO;
import org.hired.interfaces.IEstadoBO;
import org.hired.interfaces.IMunicipioBO;

/**
 *
 * @author ildex
 */
@WebServlet(name = "RegistrarServlet", urlPatterns = {"/register"})
public class RegistrarServlet extends HttpServlet {

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
        try {
            this.processCreate(request, response);
            return;
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String tel = request.getParameter("tel");
        String contrasena = request.getParameter("pass");
        String genero = request.getParameter("genero");
        String ciudad = request.getParameter("ciudad");
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        Part filePart = request.getPart("avatarArchivo");
        byte[] fileBytes = null;
        if (filePart != null) {
            InputStream fileContent = filePart.getInputStream();
            fileBytes = fileContent.readAllBytes();
        }

        if (nombre == null
                || nombre.isBlank()
                || nombre.trim().length() > 25
                || correo == null
                || correo.isBlank()
                || correo.trim().length() > 50
                || tel == null
                || tel.isBlank()
                || tel.trim().length() > 12
                || contrasena == null
                || contrasena.isBlank()
                || contrasena.trim().length() < 4 && contrasena.trim().length() > 20
                || genero == null
                || genero.isBlank()
                || ciudad == null
                || ciudad.isBlank()
                || ciudad.trim().length() > 20
                || estado == null
                || estado.isBlank()
                || municipio == null
                || municipio.isBlank()
                || fechaNacimiento == null
                || fechaNacimiento.isBlank()) {
            request.setAttribute("error", "Error al registrarse");
            getServletContext().getRequestDispatcher("/error/errorHttp.jsp").forward(request, response);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = dateFormat.parse(fechaNacimiento);
        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(nombre);
        usuario.setCorreo(correo);
        usuario.setTelefono(tel);
        usuario.setContrasena(contrasena);
        if (genero.equals("masculino")) {
            usuario.setGenero(Genero.MASCULINO);
        } else {
            usuario.setGenero(Genero.FEMENINO);
        }
        usuario.setCiudad(ciudad);
        usuario.setFechaNacimiento(fecha);
        if (fileBytes != null) {
            Binary avatar = new Binary(fileBytes);
            usuario.setAvatar(avatar);
        }

        Municipio municipioA = new Municipio(municipio);
        //APLICAR LOGICA DE NEGOCIO
        ICrearUsuarioBO crearUsuarioBO = new CrearUsuarioBO();
        try {
            Usuario usuarioGuardado = crearUsuarioBO.crearUsuario(usuario, municipioA, municipioA.getEstado());
            request.setAttribute("usuario", usuarioGuardado);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("error/errorJava.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("login.html").forward(request, response);
    }

    protected void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        String paginaDestino = "/register.jsp";
        getServletContext().getRequestDispatcher(paginaDestino).forward(request, response);
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
