/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.servlet;

import cl.ejb.UsuarioFacade;
import cl.entity.Usuario;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;

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
        Usuario usu;
        String usuario, password;
        RequestDispatcher rd;
        
        //Recuperamos de los input el Usuario y la Contraseña
        usuario = request.getParameter("user");
        password = request.getParameter("password");
        //Comprobamos que el usuario existe en la BD, en caso negativo devolvera usu=null
        usu = this.usuarioFacade.compruebaUsuario(usuario, password);
        //LOGIN correcto
        if(usu!=null){
            String usuid = usu.getIdUsuario().toString();
            //Guardamos en la sesion el idusuario y el objeto usuario que inicio sesion para futuras consultas
            sesion.setAttribute("idusuario", usuid);
            sesion.setAttribute("usuario", usu);
            request.setAttribute("idusuario", usuid);
            //Redireccion al muro personal del usuario
            rd = this.getServletContext().getRequestDispatcher("/VistaMuroPersonal.jsp?idamigo="+usuid);
            rd.forward(request, response);
        }
        //LOGIN incorrecto
        else{
            String login = "fail";
            request.setAttribute("login",login);
            rd = this.getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        
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