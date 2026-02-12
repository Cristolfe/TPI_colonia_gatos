/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.Veterinario;
import edu.ugd.tpi_colonia_gatos.persistencia.exceptions.NonexistentEntityException;
import edu.ugd.tpi_colonia_gatos.persistencia.exceptions.PreexistingEntityException;
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
public class VeterinarioJpaController implements Serializable {
  public VeterinarioJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    public VeterinarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Veterinario veterinario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(veterinario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVeterinario(veterinario.getDni()) != null) {
                throw new PreexistingEntityException("Veterinario " + veterinario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Veterinario veterinario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            veterinario = em.merge(veterinario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = veterinario.getDni();
                if (findVeterinario(id) == null) {
                    throw new NonexistentEntityException("The veterinario with id " + id + " no longer exists.");
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
            Veterinario veterinario;
            try {
                veterinario = em.getReference(Veterinario.class, id);
                veterinario.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The veterinario with id " + id + " no longer exists.", enfe);
            }
            em.remove(veterinario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Veterinario> findVeterinarioEntities() {
        return findVeterinarioEntities(true, -1, -1);
    }

    public List<Veterinario> findVeterinarioEntities(int maxResults, int firstResult) {
        return findVeterinarioEntities(false, maxResults, firstResult);
    }

    private List<Veterinario> findVeterinarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Veterinario.class));
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

    public Veterinario findVeterinario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Veterinario.class, id);
        } finally {
            em.close();
        }
    }

    public int getVeterinarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Veterinario> rt = cq.from(Veterinario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
