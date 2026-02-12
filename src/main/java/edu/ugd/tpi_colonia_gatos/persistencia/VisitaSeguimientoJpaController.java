/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.VisitaSeguimiento;
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
public class VisitaSeguimientoJpaController implements Serializable {
  public VisitaSeguimientoJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    public VisitaSeguimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VisitaSeguimiento visitaSeguimiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(visitaSeguimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VisitaSeguimiento visitaSeguimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            visitaSeguimiento = em.merge(visitaSeguimiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = visitaSeguimiento.getIdTarea();
                if (findVisitaSeguimiento(id) == null) {
                    throw new NonexistentEntityException("The visitaSeguimiento with id " + id + " no longer exists.");
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
            VisitaSeguimiento visitaSeguimiento;
            try {
                visitaSeguimiento = em.getReference(VisitaSeguimiento.class, id);
                visitaSeguimiento.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visitaSeguimiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(visitaSeguimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VisitaSeguimiento> findVisitaSeguimientoEntities() {
        return findVisitaSeguimientoEntities(true, -1, -1);
    }

    public List<VisitaSeguimiento> findVisitaSeguimientoEntities(int maxResults, int firstResult) {
        return findVisitaSeguimientoEntities(false, maxResults, firstResult);
    }

    private List<VisitaSeguimiento> findVisitaSeguimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VisitaSeguimiento.class));
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

    public VisitaSeguimiento findVisitaSeguimiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VisitaSeguimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisitaSeguimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VisitaSeguimiento> rt = cq.from(VisitaSeguimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
