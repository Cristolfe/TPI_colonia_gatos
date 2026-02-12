/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.AsignarGatoFamilia;
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
public class AsignarGatoFamiliaJpaController implements Serializable {

       public AsignarGatoFamiliaJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    
    
    
    
    
    public AsignarGatoFamiliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsignarGatoFamilia asignarGatoFamilia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignarGatoFamilia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsignarGatoFamilia asignarGatoFamilia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            asignarGatoFamilia = em.merge(asignarGatoFamilia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = asignarGatoFamilia.getIdTarea();
                if (findAsignarGatoFamilia(id) == null) {
                    throw new NonexistentEntityException("The asignarGatoFamilia with id " + id + " no longer exists.");
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
            AsignarGatoFamilia asignarGatoFamilia;
            try {
                asignarGatoFamilia = em.getReference(AsignarGatoFamilia.class, id);
                asignarGatoFamilia.getIdTarea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asignarGatoFamilia with id " + id + " no longer exists.", enfe);
            }
            em.remove(asignarGatoFamilia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsignarGatoFamilia> findAsignarGatoFamiliaEntities() {
        return findAsignarGatoFamiliaEntities(true, -1, -1);
    }

    public List<AsignarGatoFamilia> findAsignarGatoFamiliaEntities(int maxResults, int firstResult) {
        return findAsignarGatoFamiliaEntities(false, maxResults, firstResult);
    }

    private List<AsignarGatoFamilia> findAsignarGatoFamiliaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsignarGatoFamilia.class));
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

    public AsignarGatoFamilia findAsignarGatoFamilia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsignarGatoFamilia.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsignarGatoFamiliaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsignarGatoFamilia> rt = cq.from(AsignarGatoFamilia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
