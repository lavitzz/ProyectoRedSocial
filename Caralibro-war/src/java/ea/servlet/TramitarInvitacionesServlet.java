/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.servlet;

import cl.ejb.AmigoFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lavitz
 */
@WebServlet(name = "TramitarInvitacionesServlet", urlPatterns = {"/TramitarInvitacionesServlet"})
public class TramitarInvitacionesServlet extends HttpServlet {
    @EJB
    private AmigoFacade amigoFacade;

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
        HttpSession sesion = request.getSession();
        String confirmacion;
        String idamigo;
        String idusuario;
        
        idusuario = (String)sesion.getAttribute("idusuario");
        confirmacion = request.getParameter("ok");
        idamigo = request.getParameter("idamigo");
        //Confirmamos la solicitud de amistad
        if (confirmacion.equals("1"))
        {
            this.amigoFacade.acceptFriend(idusuario,idamigo);
        }
        //Cancelamos la solicitud de amistad
        else{
            this.amigoFacade.rejectFriend(idusuario,idamigo);
        }
        
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/VistaNotificaciones.jsp?id="+idusuario);
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
