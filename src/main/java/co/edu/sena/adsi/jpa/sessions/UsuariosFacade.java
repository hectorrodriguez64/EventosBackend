/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.TipoDocumento;
import co.edu.sena.adsi.jpa.entities.Usuarios;
import co.edu.sena.adsi.jpa.entities.Usuarios_;
import co.edu.sena.adsi.jpa.sessions.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "co.edu.sena_Eventos_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios findUsuariosByEmail(String email) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        cq.where(cb.equal(usuario.get(Usuarios_.email), email));
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    /**
     * Busca usuario por numDocumento
     *
     * @param numDocumento
     * @return Usuario
     */
    public Usuarios findUsuariosByNumDocumento(String numDocumento) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        cq.where(cb.equal(usuario.get(Usuarios_.numDocumento), numDocumento));
        TypedQuery<Usuarios> q = getEntityManager().createQuery(cq);
        try {
            return (Usuarios) q.getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public List<Usuarios> findUsers(Integer idUsuario, Boolean activo,
            String numDocumento, String email, Integer idTipoDocumento){
        
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);
        Root<Usuarios> usuario = cq.from(Usuarios.class);
        
        Predicate data = cb.conjunction();
        
        if(idUsuario != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.id), idUsuario));
        }
        
        
        if(activo != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.activo), activo));
        }
        
        if(numDocumento != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.numDocumento), numDocumento));
        }
        
        if(email != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.email), email));
        }
        
        if(idTipoDocumento != null){
            data = cb.and(data, cb.equal(usuario.get(Usuarios_.idTipoDocumento), new TipoDocumento(idTipoDocumento)));
        }
        
        cq.where(data);
        cq.orderBy(cb.asc(usuario.get(Usuarios_.apellidos)));
        TypedQuery<Usuarios> tq = em.createQuery(cq);
        
        try {
            return tq.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    
    
    
    
}
