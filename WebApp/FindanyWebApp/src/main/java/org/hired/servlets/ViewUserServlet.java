/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hired.exception.NegocioException;
import org.hired.exception.PersistenciaException;
import org.hired.findanyobjetosnegocio.Estado;
import org.hired.findanyobjetosnegocio.Municipio;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.EstadoBO;
import org.hired.impl.MunicipioBO;
import org.hired.impl.ViewUserBO;
import org.hired.interfaces.IEstadoBO;
import org.hired.interfaces.IMunicipioBO;
import org.hired.interfaces.IViewUserBO;

/**
 *
 * @author ildex
 */
@WebServlet(name = "ViewUserServlet", urlPatterns = {"/view-user"})
public class ViewUserServlet extends HttpServlet {

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
        if (action == null || action.equalsIgnoreCase("obtener-direccion")) {
            try {
                this.processObtenerMunicipioId(request, response);
            } catch (PersistenciaException ex) {
                Logger.getLogger(ViewUserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    }

    protected Municipio processObtenerMunicipioUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario == null) {
                throw new IllegalArgumentException("El objeto Usuario no está presente en la sesión");
            }

            Municipio municipio = usuario.getMunicipio();
            if (municipio == null || municipio.getNombre().isBlank()) {
                throw new IllegalArgumentException("El municipio es inválido");
            }

            return municipio;
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Error en los datos del formulario: " + e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorHttp.jsp").forward(request, response);
        }
        return null;
    }

    protected void processObtenerMunicipioId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, PersistenciaException {
        IViewUserBO viewUserBO = new ViewUserBO();
        try {
            String municipioId = this.processObtenerMunicipioUsuario(request, response).getNombre();
            String municipio = viewUserBO.obtenerMunicipioId(municipioId);
            String estado = viewUserBO.obtenerEstadoIdMunicipio(municipioId);
            request.setAttribute("municipio", municipio);
            request.setAttribute("estado", estado);
        } catch (NegocioException e) {
            request.setAttribute("error", e.getMessage());
            getServletContext().getRequestDispatcher("/error/errorJava.jsp").forward(request, response);
        }
        String paginaDestino = "/view-user.jsp";
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
