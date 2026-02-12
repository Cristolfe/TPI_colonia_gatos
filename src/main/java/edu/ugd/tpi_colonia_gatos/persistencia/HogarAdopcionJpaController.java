/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.HogarAdopcion;
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
public class HogarAdopcionJpaController implements Serializable {
  public HogarAdopcionJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    public HogarAdopcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HogarAdopcion hogarAdopcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(hogarAdopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HogarAdopcion hogarAdopcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            hogarAdopcion = em.merge(hogarAdopcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = hogarAdopcion.getIdHogar();
                if (findHogarAdopcion(id) == null) {
                    throw new NonexistentEntityException("The hogarAdopcion with id " + id + " no longer exists.");
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
            HogarAdopcion hogarAdopcion;
            try {
                hogarAdopcion = em.getReference(HogarAdopcion.class, id);
                hogarAdopcion.getIdHogar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hogarAdopcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(hogarAdopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HogarAdopcion> findHogarAdopcionEntities() {
        return findHogarAdopcionEntities(true, -1, -1);
    }

    public List<HogarAdopcion> findHogarAdopcionEntities(int maxResults, int firstResult) {
        return findHogarAdopcionEntities(false, maxResults, firstResult);
    }

    private List<HogarAdopcion> findHogarAdopcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HogarAdopcion.class));
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

    public HogarAdopcion findHogarAdopcion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HogarAdopcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getHogarAdopcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HogarAdopcion> rt = cq.from(HogarAdopcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
