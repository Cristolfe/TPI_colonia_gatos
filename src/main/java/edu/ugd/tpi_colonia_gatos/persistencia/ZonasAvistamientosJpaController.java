/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.ZonasAvistamientos;
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
public class ZonasAvistamientosJpaController implements Serializable {
  public ZonasAvistamientosJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    public ZonasAvistamientosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ZonasAvistamientos zonasAvistamientos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(zonasAvistamientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ZonasAvistamientos zonasAvistamientos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            zonasAvistamientos = em.merge(zonasAvistamientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = zonasAvistamientos.getIdAvistamiento();
                if (findZonasAvistamientos(id) == null) {
                    throw new NonexistentEntityException("The zonasAvistamientos with id " + id + " no longer exists.");
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
            ZonasAvistamientos zonasAvistamientos;
            try {
                zonasAvistamientos = em.getReference(ZonasAvistamientos.class, id);
                zonasAvistamientos.getIdAvistamiento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The zonasAvistamientos with id " + id + " no longer exists.", enfe);
            }
            em.remove(zonasAvistamientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ZonasAvistamientos> findZonasAvistamientosEntities() {
        return findZonasAvistamientosEntities(true, -1, -1);
    }

    public List<ZonasAvistamientos> findZonasAvistamientosEntities(int maxResults, int firstResult) {
        return findZonasAvistamientosEntities(false, maxResults, firstResult);
    }

    private List<ZonasAvistamientos> findZonasAvistamientosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ZonasAvistamientos.class));
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

    public ZonasAvistamientos findZonasAvistamientos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ZonasAvistamientos.class, id);
        } finally {
            em.close();
        }
    }

    public int getZonasAvistamientosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ZonasAvistamientos> rt = cq.from(ZonasAvistamientos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
