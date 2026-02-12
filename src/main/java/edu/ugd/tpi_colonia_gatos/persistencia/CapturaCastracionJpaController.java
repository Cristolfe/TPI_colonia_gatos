/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.CapturaCastracion;
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
public class CapturaCastracionJpaController implements Serializable {

    
        public CapturaCastracionJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    
    
    public CapturaCastracionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CapturaCastracion capturaCastracion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(capturaCastracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CapturaCastracion capturaCastracion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            capturaCastracion = em.merge(capturaCastracion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = capturaCastracion.getIdTarea();
                if (findCapturaCastracion(id) == null) {
                    throw new NonexistentEntityException("The capturaCastracion with id " + id + " no longer exists.");
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
            CapturaCastracion capturaCastracion;
            try {
                capturaCastracion = em.getReference(CapturaCastracion.class, id);
                capturaCastracion.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The capturaCastracion with id " + id + " no longer exists.", enfe);
            }
            em.remove(capturaCastracion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CapturaCastracion> findCapturaCastracionEntities() {
        return findCapturaCastracionEntities(true, -1, -1);
    }

    public List<CapturaCastracion> findCapturaCastracionEntities(int maxResults, int firstResult) {
        return findCapturaCastracionEntities(false, maxResults, firstResult);
    }

    private List<CapturaCastracion> findCapturaCastracionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CapturaCastracion.class));
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

    public CapturaCastracion findCapturaCastracion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CapturaCastracion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCapturaCastracionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CapturaCastracion> rt = cq.from(CapturaCastracion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
