/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.Alimentacion;
import edu.ugd.tpi_colonia_gatos.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wowle
 */
public class AlimentacionJpaController implements Serializable {

     public AlimentacionJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    
    
    
    
    
    
    
    
    
    public AlimentacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alimentacion alimentacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alimentacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alimentacion alimentacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alimentacion = em.merge(alimentacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = alimentacion.getIdTarea();
                if (findAlimentacion(id) == null) {
                    throw new NonexistentEntityException("The alimentacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alimentacion alimentacion;
            try {
                alimentacion = em.getReference(Alimentacion.class, id);
                alimentacion.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alimentacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(alimentacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alimentacion> findAlimentacionEntities() {
        return findAlimentacionEntities(true, -1, -1);
    }

    public List<Alimentacion> findAlimentacionEntities(int maxResults, int firstResult) {
        return findAlimentacionEntities(false, maxResults, firstResult);
    }

    private List<Alimentacion> findAlimentacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alimentacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Alimentacion findAlimentacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alimentacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlimentacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alimentacion> rt = cq.from(Alimentacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
