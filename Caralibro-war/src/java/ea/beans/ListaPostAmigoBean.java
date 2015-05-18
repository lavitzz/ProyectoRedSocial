/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.PostFacade;
import cl.entity.Post;
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
public class ListaPostAmigoBean {
    @EJB
    private PostFacade postFacade;
    
    @ManagedProperty(value="#{listaAmigosBean}")
    private ListaAmigosBean listaAmigosBean;
    /**
     * Creates a new instance of ListaPostAmigoBean
     */
    private List<Post> listaPost;
    
    public ListaPostAmigoBean() {
    }

    public ListaAmigosBean getListaAmigosBean() {
        return listaAmigosBean;
    }

    public void setListaAmigosBean(ListaAmigosBean listaAmigosBean) {
        this.listaAmigosBean = listaAmigosBean;
    }

    public List<Post> getListaPost() {
        return listaPost;
    }

    public void setListaPost(List<Post> listaPost) {
        this.listaPost = listaPost;
    }
   
    @PostConstruct
    public void init(){
        Usuario amigo = listaAmigosBean.getAmigoSeleccionado();
        listaPost = this.postFacade.findPostbyAuthorID(amigo.getIdUsuario().toString());
    }
    
}
