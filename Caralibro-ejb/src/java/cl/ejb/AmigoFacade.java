/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ejb;

import cl.entity.Amigo;
import cl.entity.Usuario;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class AmigoFacade extends AbstractFacade<Amigo> {
    @PersistenceContext(unitName = "Caralibro-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AmigoFacade() {
        super(Amigo.class);
    }
    
    public List<Usuario> findFriendsByID(String id){
        Query q;
        List<Usuario> listaAmigos;        
        
        q = em.createQuery("SELECT u FROM Usuario u JOIN u.amigoCollection1 a WHERE a.amigoPK.idAmigo = :id AND a.confirmado = 1");
        //q = em.createQuery("SELECT u FROM Usuario u WHERE (u.amigoCollection1.usuario.idUsuario = :id OR u.amigoCollection1.usuario1.idUsuario = :id) AND (u.amigoCollection1.confirmado = 1)");
        //q = em.createQuery("SELECT u FROM Usuario u JOIN u.amigoCollection1 a WHERE (a.amigoPK.idAmigo = :id OR a.amigoPK.idUsuario = :id ) AND a.confirmado = 1");
        q.setParameter("id", new BigDecimal(id));
        listaAmigos = q.getResultList();
        return listaAmigos;
    }
    
    public Amigo createFriend(BigDecimal user, BigDecimal inv){
        Amigo a = new Amigo(user.toBigInteger(),inv.toBigInteger());
        a.setConfirmado(BigInteger.ZERO);
        return a;
    }
    
    public List<Usuario> searchInvitations(BigDecimal id){
        Query q;
        List<Usuario> listaI;
        
        q = em.createQuery("SELECT a.usuario FROM Amigo a WHERE a.usuario1.idUsuario = :id AND a.confirmado = 0 ");
        q.setParameter("id", id);
        listaI = q.getResultList();
        
        return listaI;
    }
    
    public void acceptFriend(String idusuario, String idamigo){
        Query q;
        q = em.createQuery("UPDATE Amigo a SET a.confirmado = 1 WHERE a.usuario1.idUsuario = :idusuario AND a.usuario.idUsuario = :idamigo");
        q.setParameter("idusuario", new BigDecimal(idusuario));
        q.setParameter("idamigo", new BigDecimal(idamigo));
        int updated = q.executeUpdate();
    }
    
    public void rejectFriend(String idusuario, String idamigo){
        Query q;
        q = em.createQuery("DELETE FROM Amigo a WHERE a.usuario1.idUsuario = :idusuario AND a.usuario.idUsuario = :idamigo");
        q.setParameter("idusuario", new BigDecimal(idusuario));
        q.setParameter("idamigo", new BigDecimal(idamigo));
        int deleted = q.executeUpdate();
    }   
}
