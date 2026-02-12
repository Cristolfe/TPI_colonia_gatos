/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.Diagnosticos;
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
public class DiagnosticosJpaController implements Serializable {
    
    public DiagnosticosJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }

    public DiagnosticosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Diagnosticos diagnosticos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(diagnosticos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Diagnosticos diagnosticos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            diagnosticos = em.merge(diagnosticos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = diagnosticos.getIdDiagnostico();
                if (findDiagnosticos(id) == null) {
                    throw new NonexistentEntityException("The diagnosticos with id " + id + " no longer exists.");
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
            Diagnosticos diagnosticos;
            try {
                diagnosticos = em.getReference(Diagnosticos.class, id);
                diagnosticos.getIdDiagnostico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diagnosticos with id " + id + " no longer exists.", enfe);
            }
            em.remove(diagnosticos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Diagnosticos> findDiagnosticosEntities() {
        return findDiagnosticosEntities(true, -1, -1);
    }

    public List<Diagnosticos> findDiagnosticosEntities(int maxResults, int firstResult) {
        return findDiagnosticosEntities(false, maxResults, firstResult);
    }

    private List<Diagnosticos> findDiagnosticosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Diagnosticos.class));
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

    public Diagnosticos findDiagnosticos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Diagnosticos.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiagnosticosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Diagnosticos> rt = cq.from(Diagnosticos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
