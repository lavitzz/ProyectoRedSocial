/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.servlet;

import cl.ejb.AmigoFacade;
import cl.ejb.UsuarioFacade;
import cl.entity.Usuario;
import cl.entity.Amigo;
import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
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
@WebServlet(name = "InvitarAmigoServlet", urlPatterns = {"/InvitarAmigoServlet"})
public class InvitarAmigoServlet extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;
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
        String idusuario;
        String nameamigo;
        Usuario u;
        Amigo ami;
        
        idusuario = (String) sesion.getAttribute("idusuario");
        nameamigo = request.getParameter("nombreamigo");
        
        u = this.usuarioFacade.getUsuarioByEmail(nameamigo);
        
        if (u!=null){
            ami = this.amigoFacade.insertaAmigoByID(new BigDecimal(idusuario), u.getIdUsuario());
            if(ami!=null){
                this.amigoFacade.create(ami);
            }
           
        }
        
        response.sendRedirect("/Caralibro-war/CargaMuroPersonal?idamigo="+idusuario);

        
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
