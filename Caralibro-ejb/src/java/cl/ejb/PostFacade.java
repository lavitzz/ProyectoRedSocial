/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ejb;

import cl.entity.Post;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lavitz
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> {
    @PersistenceContext(unitName = "Caralibro-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    public List<Post> findPostbyAuthorID (String id) {
        Query q;
        List<Post> listaPosts;        
        
        q = em.createQuery("SELECT p FROM POST p WHERE p.getAutor.getIdUsuario = :id");
        q.setParameter("author", id);
        listaPosts = q.getResultList();
        return listaPosts;
        //Estamos en test
        //mierda ya
    }
    
}
