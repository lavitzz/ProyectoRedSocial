/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.AmigoFacade;
import cl.entity.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lavitz
 */
@ManagedBean
@SessionScoped
public class ListaAmigosBean {
    @EJB
    private AmigoFacade amigoFacade;
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
    
    private List<Usuario> listaAmigos;
    private Usuario AmigoSeleccionado;
    /**
     * Creates a new instance of ListaAmigosBean
     */
    public ListaAmigosBean() {
    }

    public List<Usuario> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(List<Usuario> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    public Usuario getAmigoSeleccionado() {
        return AmigoSeleccionado;
    }

    public void setAmigoSeleccionado(Usuario AmigoSeleccionado) {
        this.AmigoSeleccionado = AmigoSeleccionado;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    public String doVerMuroAmigo(){
        return "VistaMuroAmigo";
    }
    
    @PostConstruct
    public void init(){
        listaAmigos = this.amigoFacade.findFriendsByID(loginBean.getUser().getIdUsuario().toString());
    }
    
    
}
