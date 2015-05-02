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
        
        //q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :id");
        //SELECT * FROM USUARIO WHERE ID_USUARIO IN (SELECT ID_AMIGO FROM AMIGO WHERE ID_USUARIO = 1)
        //q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario IN (SELECT a.idUsuario FROM Amigo a WHERE a.idUsuario = :id)");
        //q = em.createQuery("SELECT u FROM Usuario u JOIN u.amigo a WHERE a.usuario.idUsuario = :id");
        q = em.createQuery("SELECT u FROM Usuario u JOIN u.amigoCollection1 a WHERE a.amigoPK.idAmigo = :id AND a.confirmado = 1");
        q.setParameter("id", new BigDecimal(id));
        listaAmigos = q.getResultList();
        return listaAmigos;
    }
    
    public Amigo insertaAmigoByID(BigDecimal id, BigDecimal amigo){
        Amigo a = new Amigo(id.toBigInteger(),amigo.toBigInteger());
        a.setConfirmado(BigInteger.ZERO);
        return a;
    }
    
}
