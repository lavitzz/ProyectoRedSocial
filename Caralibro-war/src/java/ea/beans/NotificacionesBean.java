/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.AmigoFacade;
import cl.ejb.UsuarioFacade;
import cl.entity.Amigo;
import cl.entity.Usuario;
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
    private UsuarioFacade usuarioFacade;
    @EJB
    private AmigoFacade amigoFacade;
    
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
    
    @ManagedProperty(value="#{listaAmigosBean}")
    private ListaAmigosBean listaAmigosBean;
    
    /**
     * Creates a new instance of NotificacionesBean
     */
    
    private List<Usuario> listaInvitaciones;
    private Usuario invitacionSeleccionada;
    private String correoInvitacion;
    private List<Usuario> listaAmigos;
   
    public NotificacionesBean() {
    }

    public List<Usuario> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(List<Usuario> listaAmigos) {
        this.listaAmigos = listaAmigos;
    }

    public List<Usuario> getListaInvitaciones() {
        return listaInvitaciones;
    }

    public void setListaInvitaciones(List<Usuario> listaInvitaciones) {
        this.listaInvitaciones = listaInvitaciones;
    }

    public ListaAmigosBean getListaAmigosBean() {
        return listaAmigosBean;
    }

    public void setListaAmigosBean(ListaAmigosBean listaAmigosBean) {
        this.listaAmigosBean = listaAmigosBean;
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

    public String getCorreoInvitacion() {
        return correoInvitacion;
    }

    public void setCorreoInvitacion(String correoInvitacion) {
        this.correoInvitacion = correoInvitacion;
    }
    
    public String doAceptar(){
        //Aceptar invitacion y crear entrada en la tabla para crear la amistad en los dos sentidos
        this.amigoFacade.acceptFriend(loginBean.getUser().getIdUsuario().toString(), invitacionSeleccionada.getIdUsuario().toString());
        this.amigoFacade.createInv(loginBean.getUser().getIdUsuario(), invitacionSeleccionada.getIdUsuario());
        //Actualizamos la lista de invitaciones
        listaInvitaciones = this.amigoFacade.searchInvitations(loginBean.getUser().getIdUsuario());
        //Actualizar la lista de amigos ?¿?¿?¿
        
        //Volvemos a la vista del muro
        return "VistaMuroPersonal";
    }
    
    public String doRechazar(){
        //Rechazamos la invitacion de nuevo amigo, borrando la entrada de la BD
        this.amigoFacade.rejectFriend(loginBean.getUser().getIdUsuario().toString(), invitacionSeleccionada.getIdUsuario().toString());
        //Actualizamos la lista de invitaciones
        listaInvitaciones = this.amigoFacade.searchInvitations(loginBean.getUser().getIdUsuario());
        //Volvemos a la vista del muro
        return "VistaMuroPersonal";
    }
    
    public String doEnviarInvitacion(){
        Usuario invitado;
        Amigo amistad;
        try{       
            invitado = this.usuarioFacade.findUserbyEmail(correoInvitacion);
            amistad = this.amigoFacade.createFriend(loginBean.getUser().getIdUsuario(),invitado.getIdUsuario());
            this.amigoFacade.create(amistad);
        }
        catch(NullPointerException e){
            return "error";
        }
        correoInvitacion = "";
        return "VistaMuroPersonal";
    }
    
    @PostConstruct
    public void init(){
        listaInvitaciones = this.amigoFacade.searchInvitations(loginBean.getUser().getIdUsuario());
    }
    
}
