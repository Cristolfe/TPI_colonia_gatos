/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.ControlVeterinario;
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
public class ControlVeterinarioJpaController implements Serializable {
     public ControlVeterinarioJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
   
    public ControlVeterinarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ControlVeterinario controlVeterinario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(controlVeterinario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ControlVeterinario controlVeterinario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            controlVeterinario = em.merge(controlVeterinario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = controlVeterinario.getIdTarea();
                if (findControlVeterinario(id) == null) {
                    throw new NonexistentEntityException("The controlVeterinario with id " + id + " no longer exists.");
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
            ControlVeterinario controlVeterinario;
            try {
                controlVeterinario = em.getReference(ControlVeterinario.class, id);
                controlVeterinario.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The controlVeterinario with id " + id + " no longer exists.", enfe);
            }
            em.remove(controlVeterinario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ControlVeterinario> findControlVeterinarioEntities() {
        return findControlVeterinarioEntities(true, -1, -1);
    }

    public List<ControlVeterinario> findControlVeterinarioEntities(int maxResults, int firstResult) {
        return findControlVeterinarioEntities(false, maxResults, firstResult);
    }

    private List<ControlVeterinario> findControlVeterinarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ControlVeterinario.class));
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

    public ControlVeterinario findControlVeterinario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ControlVeterinario.class, id);
        } finally {
            em.close();
        }
    }

    public int getControlVeterinarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ControlVeterinario> rt = cq.from(ControlVeterinario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
