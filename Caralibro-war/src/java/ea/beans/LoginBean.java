/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.UsuarioFacade;
import cl.entity.Usuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lavitz
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    @EJB
    private UsuarioFacade usuarioFacade;
    
    //Validacion fuera del XHTML
    private Usuario user;
    @NotNull
    private String email;
    @NotNull
    private String pwd;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String doLogin(){
        this.user = this.usuarioFacade.compruebaUsuario(this.email, this.pwd);
        if (user!=null){
            return "VistaMuroPersonal";
        }
        else{
            return "index";
        }
    }
    
    public String doCerrarSesion(){
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sesion.invalidate();
        return "index";
    }
    
}
