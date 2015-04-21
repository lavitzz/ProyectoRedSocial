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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    
    public void insertaPostbyAuthorID (String id, String texto){
        Query q;
        Usuario user;
        Grupo g;
        String idgrupo = "0";
        Date fechaActual = new Date();
        //DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss,000000000");
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
        String fecha = formatoFecha.format(fechaActual);
        
        Post p = new Post(new BigDecimal("3"));
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :id");
        q.setParameter("id", new BigDecimal(id));
        user = (Usuario) q.getSingleResult();
        p.setAutor(user);
        p.setFecha(fechaActual);
        q = em.createQuery("SELECT g FROM Grupo g WHERE g.idGrupo = 0");
        //q.setParameter("idgrupo", idgrupo);
        g = (Grupo) q.getSingleResult();
        p.setGrupo(g);
        p.setTexto(texto);
        em.persist(p);
        em.getTransaction().commit();
        /*q = em.createNativeQuery("INSERT INTO Post (ID_POST, FECHA, TEXTO, AUTOR, GRUPO) values(3, '2007-08-08,09', 'hola', 1, 0);");
        q.executeUpdate();
        //INSERT INTO Post (ID_POST, FECHA, TEXTO, AUTOR, GRUPO) values(3, '2007-08-08,09', 'hola', 1, 0);
        */
    }
    
}
