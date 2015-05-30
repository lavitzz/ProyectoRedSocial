/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.UsuarioFacade;
import cl.entity.Usuario;
import java.awt.event.ActionEvent;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.primefaces.context.RequestContext;

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
    @Size(min=6, max=60)
    private String email;
    @NotNull
    @Size(min=4, max=20)
    private String pwd;
    private boolean logueado = false;

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

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
    
    public String doLogin(){
        FacesMessage message = null;
        this.user = this.usuarioFacade.compruebaUsuario(this.email, this.pwd);
        if (user!=null){
            //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", email);
            //FacesContext.getCurrentInstance().addMessage(null, message);
            return "VistaMuroPersonal";
        }
        else{
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "index";
        }
        
    }
    
    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        this.user = this.usuarioFacade.compruebaUsuario(this.email, this.pwd);
        if (user!=null) {
            logueado = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", email);
        } else {
            logueado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en el Login","Credenciales no válidas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("estaLogeado", logueado);
        if (logueado){
          context.addCallbackParam("view", "/Caralibro-war/faces/VistaMuroPersonal.xhtml");
        }
    }
    
    public String doLogout(){
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sesion.invalidate();
        return "index";
    }
    
}
