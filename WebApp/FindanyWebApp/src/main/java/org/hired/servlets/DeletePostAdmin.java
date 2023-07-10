/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.hired.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hired.exception.NegocioException;
import org.hired.findanyobjetosnegocio.Post;
import org.hired.impl.PostBO;
import org.hired.interfaces.IPostBO;

/**
 *
 * @author ildex
 */
@WebServlet(name = "DeletePostAdmin", urlPatterns = {"/delete-post-admin"})
public class DeletePostAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processDeletePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NegocioException {
        IPostBO postBO = new PostBO();
        String postId = request.getParameter("id");
        if (postId == null || postId.isEmpty()) {
            throw new IllegalArgumentException("No se proporcionó un ID de comentario válido");
        }
        Post post = postBO.buscarPorId(postId);
        postBO.eliminarPost(post);
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
        try {
            this.processDeletePost(request, response);
        } catch (NegocioException ex) {
            Logger.getLogger(DeletePostAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
