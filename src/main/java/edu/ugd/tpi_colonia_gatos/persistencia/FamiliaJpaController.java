/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.Familia;
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
public class FamiliaJpaController implements Serializable {
  public FamiliaJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    public FamiliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familia familia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(familia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFamilia(familia.getDni()) != null) {
                throw new PreexistingEntityException("Familia " + familia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familia familia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            familia = em.merge(familia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = familia.getDni();
                if (findFamilia(id) == null) {
                    throw new NonexistentEntityException("The familia with id " + id + " no longer exists.");
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
            Familia familia;
            try {
                familia = em.getReference(Familia.class, id);
                familia.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familia with id " + id + " no longer exists.", enfe);
            }
            em.remove(familia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familia> findFamiliaEntities() {
        return findFamiliaEntities(true, -1, -1);
    }

    public List<Familia> findFamiliaEntities(int maxResults, int firstResult) {
        return findFamiliaEntities(false, maxResults, firstResult);
    }

    private List<Familia> findFamiliaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familia.class));
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

    public Familia findFamilia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familia.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamiliaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familia> rt = cq.from(Familia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
