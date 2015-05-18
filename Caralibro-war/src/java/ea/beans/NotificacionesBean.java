/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.AmigoFacade;
import cl.entity.Usuario;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class NotificacionesBean {
    @EJB
    private AmigoFacade amigoFacade;
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
    
    /**
     * Creates a new instance of NotificacionesBean
     */
    
    private List<Usuario> listaInvitaciones;
    private Usuario invitacionSeleccionada;
   
    public NotificacionesBean() {
    }

    public List<Usuario> getListaInvitaciones() {
        return listaInvitaciones;
    }

    public void setListaInvitaciones(List<Usuario> listaInvitaciones) {
        this.listaInvitaciones = listaInvitaciones;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Usuario getInvitacionSeleccionada() {
        return invitacionSeleccionada;
    }

    public void setInvitacionSeleccionada(Usuario invitacionSeleccionada) {
        this.invitacionSeleccionada = invitacionSeleccionada;
    }
    
    public String doAceptar(){
        this.amigoFacade.acceptFriend(loginBean.getUser().getIdUsuario().toString(), invitacionSeleccionada.getIdUsuario().toString());
        listaInvitaciones = this.amigoFacade.searchInvitations(loginBean.getUser().getIdUsuario());
        return "VistaNotificaciones";
    }
    
    public String doRechazar(){
        this.amigoFacade.rejectFriend(loginBean.getUser().getIdUsuario().toString(), invitacionSeleccionada.getIdUsuario().toString());
        listaInvitaciones = this.amigoFacade.searchInvitations(loginBean.getUser().getIdUsuario());
        return "VistaNotificaciones";
    }
    
    @PostConstruct
    public void init(){
        listaInvitaciones = this.amigoFacade.searchInvitations(loginBean.getUser().getIdUsuario());
    }
    
}
