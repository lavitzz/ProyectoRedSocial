/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.servlet;

import cl.ejb.PostFacade;
import cl.entity.Post;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lavitz
 */
@WebServlet(name = "ListaPostServlet", urlPatterns = {"/ListaPostServlet"})
public class ListaPostServlet extends HttpServlet {
    @EJB
    private PostFacade postFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Post> listaPost;
        String id;
        
        //Recuperamos de la URL el id del usuario del cual debemos mostrar sus post
        id = request.getParameter("idpost");
        //Mediante una consulta a la BD traemos la lista de Post del usuario
        listaPost = this.postFacade.findPostbyAuthorID(id);
        request.setAttribute("listaP", listaPost);
        //El id destinatario es el id del URL si estamos en el muro de un amigo, insertaremos en su muro los mensajes
        //por el contrario si estamos en nuestro muro insertaremos en el.
        request.setAttribute("iddest", id);
        
        //Redireccion con "include" para insertar la lista en la Vista
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/listaPost.jsp");
        rd.include(request, response);       
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
        processRequest(request, response);
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
        processRequest(request, response);
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
