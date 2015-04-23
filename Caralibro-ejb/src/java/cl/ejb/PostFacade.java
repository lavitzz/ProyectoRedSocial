/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ejb;

import cl.entity.Grupo;
import cl.entity.Post;
import cl.entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
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
        
        q = em.createQuery("SELECT p FROM Post p WHERE p.autor.idUsuario = :id");
        q.setParameter("id", new BigDecimal(id));
        listaPosts = q.getResultList();
        return listaPosts;
    }
    
    public Post insertaPostbyAuthorID (String id, String texto){
        Query q;
        Usuario user;
        Grupo g;
        Date fechaActual = new Date();
        BigDecimal idd = new BigDecimal(id);
        
        Post p = new Post();
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :id");
        q.setParameter("id", new BigDecimal(id));
        user = (Usuario) q.getSingleResult();
        p.setAutor(user);
        p.setFecha(fechaActual);
        //SIEMPRE GRUPO 0 prueba
        q = em.createQuery("SELECT g FROM Grupo g WHERE g.idGrupo = 0");
        g = (Grupo) q.getSingleResult();
        p.setGrupo(g);
        p.setTexto(texto);
        return p;
        /*q = em.createNativeQuery("INSERT INTO Post (ID_POST, FECHA, TEXTO, AUTOR, GRUPO) values(3, '2007-08-08,09', 'hola', 1, 0);");
        q.executeUpdate();
        //INSERT INTO Post (ID_POST, FECHA, TEXTO, AUTOR, GRUPO) values(3, '2007-08-08,09', 'hola', 1, 0);
        INSERT INTO Post (ID_POST, FECHA, TEXTO, AUTOR, GRUPO) values(3, '22-abr-2015 17:11:04', 'hola', 1, 0);
        */
    }
    
}
