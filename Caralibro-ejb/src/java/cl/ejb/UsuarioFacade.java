/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ejb;

import cl.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lavitz
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "Caralibro-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario compruebaUsuario(String email, String pass){
        Query q;
        List<Usuario> listaU;
        
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :email AND u.password = :pass");
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        listaU = q.getResultList();
        if (!listaU.isEmpty()){
            return listaU.get(0);
        }
        else{
            return null;
        }
    }
    
    public Usuario findUserbyEmail(String email){
        Query q;
        Usuario u;
        try{
            q = em.createNamedQuery("Usuario.findByCorreo");
            q.setParameter("correo", email);
            u = (Usuario) q.getSingleResult();
        }
        catch(NoResultException e){
            return null;
        }     
        return u;
    }
    
    public Usuario findUserbyID(String id){
        Query q;
        Usuario u;
        
        q = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario");
        q.setParameter("idUsuario", id);
        u = (Usuario)q.getSingleResult();
        
        return u;
    }
    
}
