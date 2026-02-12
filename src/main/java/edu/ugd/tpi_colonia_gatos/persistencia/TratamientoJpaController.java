/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.Tratamiento;
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
public class TratamientoJpaController implements Serializable {
   public TratamientoJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }

    public TratamientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tratamiento tratamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tratamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tratamiento tratamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tratamiento = em.merge(tratamiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tratamiento.getIdTratamiento();
                if (findTratamiento(id) == null) {
                    throw new NonexistentEntityException("The tratamiento with id " + id + " no longer exists.");
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
            Tratamiento tratamiento;
            try {
                tratamiento = em.getReference(Tratamiento.class, id);
                tratamiento.getIdTratamiento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tratamiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tratamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tratamiento> findTratamientoEntities() {
        return findTratamientoEntities(true, -1, -1);
    }

    public List<Tratamiento> findTratamientoEntities(int maxResults, int firstResult) {
        return findTratamientoEntities(false, maxResults, firstResult);
    }

    private List<Tratamiento> findTratamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tratamiento.class));
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

    public Tratamiento findTratamiento(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tratamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTratamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tratamiento> rt = cq.from(Tratamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
