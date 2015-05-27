/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ea.beans;

import cl.ejb.PostFacade;
import cl.entity.Post;
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
public class ListaPostBean {
    @EJB
    private PostFacade postFacade;
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
    
    private List<Post> listaPost;
    private List<Post> listaMisPost;
    /**
     * Creates a new instance of ListaPostBean
     */
    public ListaPostBean() {
    }

    public List<Post> getListaPost() {
        return listaPost;
    }

    public void setListaPost(List<Post> listaPost) {
        this.listaPost = listaPost;
    }

    public List<Post> getListaMisPost() {
        return listaMisPost;
    }

    public void setListaMisPost(List<Post> listaMisPost) {
        this.listaMisPost = listaMisPost;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    
    @PostConstruct
    private void init(){
        listaPost = this.postFacade.findPostbyAuthorID(loginBean.getUser().getIdUsuario().toString());
        listaMisPost = this.postFacade.findPost(loginBean.getUser().getIdUsuario().toString());
    }
    
}
