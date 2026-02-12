/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.CertificadosAdopcion;
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
public class CertificadosAdopcionJpaController implements Serializable {

         public CertificadosAdopcionJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    
    
    
    
    
    public CertificadosAdopcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CertificadosAdopcion certificadosAdopcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(certificadosAdopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CertificadosAdopcion certificadosAdopcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            certificadosAdopcion = em.merge(certificadosAdopcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = certificadosAdopcion.getIdCertificado();
                if (findCertificadosAdopcion(id) == null) {
                    throw new NonexistentEntityException("The certificadosAdopcion with id " + id + " no longer exists.");
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
            CertificadosAdopcion certificadosAdopcion;
            try {
                certificadosAdopcion = em.getReference(CertificadosAdopcion.class, id);
                certificadosAdopcion.getIdCertificado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The certificadosAdopcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(certificadosAdopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CertificadosAdopcion> findCertificadosAdopcionEntities() {
        return findCertificadosAdopcionEntities(true, -1, -1);
    }

    public List<CertificadosAdopcion> findCertificadosAdopcionEntities(int maxResults, int firstResult) {
        return findCertificadosAdopcionEntities(false, maxResults, firstResult);
    }

    private List<CertificadosAdopcion> findCertificadosAdopcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CertificadosAdopcion.class));
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

    public CertificadosAdopcion findCertificadosAdopcion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CertificadosAdopcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getCertificadosAdopcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CertificadosAdopcion> rt = cq.from(CertificadosAdopcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
