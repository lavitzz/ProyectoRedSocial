/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.ejb;

import ea.entity.Post;
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
public class PostFacade extends AbstractFacade<Post>{
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
    public List<Post> findByAuthorPost (String auth) {
        Query q;
        List<Post> listaPosts;        
        
        q = em.createQuery("SELECT p FROM Post p WHERE c.zip.zipCode = :auth");
        q.setParameter("CP", auth);
        listaPosts = q.getResultList();
        return listaPosts;
        
    }
    
}
