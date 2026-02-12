/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia.exceptions;

import edu.ugd.tpi_colonia_gatos.modelo.TrasporteHogar;
import edu.ugd.tpi_colonia_gatos.persistencia.exceptions.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wowle
 */
public class TrasporteHogarJpaController implements Serializable {

    public TrasporteHogarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TrasporteHogar trasporteHogar) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trasporteHogar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TrasporteHogar trasporteHogar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trasporteHogar = em.merge(trasporteHogar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = trasporteHogar.getIdTarea();
                if (findTrasporteHogar(id) == null) {
                    throw new NonexistentEntityException("The trasporteHogar with id " + id + " no longer exists.");
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
            TrasporteHogar trasporteHogar;
            try {
                trasporteHogar = em.getReference(TrasporteHogar.class, id);
                trasporteHogar.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trasporteHogar with id " + id + " no longer exists.", enfe);
            }
            em.remove(trasporteHogar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TrasporteHogar> findTrasporteHogarEntities() {
        return findTrasporteHogarEntities(true, -1, -1);
    }

    public List<TrasporteHogar> findTrasporteHogarEntities(int maxResults, int firstResult) {
        return findTrasporteHogarEntities(false, maxResults, firstResult);
    }

    private List<TrasporteHogar> findTrasporteHogarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TrasporteHogar.class));
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

    public TrasporteHogar findTrasporteHogar(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TrasporteHogar.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrasporteHogarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TrasporteHogar> rt = cq.from(TrasporteHogar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
