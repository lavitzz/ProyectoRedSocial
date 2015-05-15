/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.PostFacade;
import cl.ejb.UsuarioFacade;
import cl.entity.Post;
import cl.entity.Usuario;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author lavitz
 */
@ManagedBean
@RequestScoped
public class InsertarPostBean {
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private PostFacade postFacade;
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
   
    private Usuario destinatario;
    private String texto;
    /**
     * Creates a new instance of InsertarPostBean
     */
    public InsertarPostBean() {
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public String doInsertar(){
        Post p;
        p = this.postFacade.insertaPostbyAuthorID(loginBean.getUser().getIdUsuario().toString(), loginBean.getUser().getIdUsuario().toString() , texto );
        this.postFacade.create(p);
        this.texto = "";
        return "VistaMuroPersonal";
    }
    
}
