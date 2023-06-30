/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Usuario;
import org.hired.impl.LoginUsuarioBO;
import org.hired.interfaces.ILoginUsuarioBO;

/**
 *
 * @author ildex
 */
@WebServlet(name = "AuthServlet", urlPatterns = {"/auth"})
public class AuthServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("pass");
        ILoginUsuarioBO loginUsuarioBO = new LoginUsuarioBO();
        if (!loginUsuarioBO.AuthUsuario(correo, contrasena)) {
            getServletContext().getRequestDispatcher("/login.html").forward(request, response);
        }
        Usuario usuarioLogueado = loginUsuarioBO.busquedaUsuario(correo);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usuarioLogueado);
        getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);

    }

    protected void processLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
        if (action != null && action.equalsIgnoreCase("login")) {
            try {
                processLogin(request, response);
                return;
            } catch (NegocioException ex) {
                Logger.getLogger(AuthServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (action != null && action.equalsIgnoreCase("logout")) {
            processLogout(request, response);
            return;
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
