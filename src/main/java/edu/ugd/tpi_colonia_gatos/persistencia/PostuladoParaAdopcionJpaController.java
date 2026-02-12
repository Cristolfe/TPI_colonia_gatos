/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ugd.tpi_colonia_gatos.persistencia;

import edu.ugd.tpi_colonia_gatos.modelo.PostuladoParaAdopcion;
import edu.ugd.tpi_colonia_gatos.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author wowle
 */
public class PostuladoParaAdopcionJpaController implements Serializable {
  public PostuladoParaAdopcionJpaController() {
         emf=Persistence.createEntityManagerFactory("colonia_gatos");
    }
    public PostuladoParaAdopcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PostuladoParaAdopcion postuladoParaAdopcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(postuladoParaAdopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PostuladoParaAdopcion postuladoParaAdopcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            postuladoParaAdopcion = em.merge(postuladoParaAdopcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = postuladoParaAdopcion.getIdPostulacion();
                if (findPostuladoParaAdopcion(id) == null) {
                    throw new NonexistentEntityException("The postuladoParaAdopcion with id " + id + " no longer exists.");
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
            PostuladoParaAdopcion postuladoParaAdopcion;
            try {
                postuladoParaAdopcion = em.getReference(PostuladoParaAdopcion.class, id);
                postuladoParaAdopcion.getIdPostulacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The postuladoParaAdopcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(postuladoParaAdopcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PostuladoParaAdopcion> findPostuladoParaAdopcionEntities() {
        return findPostuladoParaAdopcionEntities(true, -1, -1);
    }

    public List<PostuladoParaAdopcion> findPostuladoParaAdopcionEntities(int maxResults, int firstResult) {
        return findPostuladoParaAdopcionEntities(false, maxResults, firstResult);
    }

    private List<PostuladoParaAdopcion> findPostuladoParaAdopcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PostuladoParaAdopcion.class));
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

    public PostuladoParaAdopcion findPostuladoParaAdopcion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PostuladoParaAdopcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getPostuladoParaAdopcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PostuladoParaAdopcion> rt = cq.from(PostuladoParaAdopcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
    
    
    public List<PostuladoParaAdopcion> obtenerGatosAdoptados() {
    EntityManager em = emf.createEntityManager();
    List<PostuladoParaAdopcion> lista = null;

    try {
        lista = em.createQuery(
            "SELECT p FROM PostuladoParaAdopcion p WHERE p.aceptado = true", 
            PostuladoParaAdopcion.class
        ).getResultList();
    } finally {
        em.close();
    }

    return lista;
}
    
public List<PostuladoParaAdopcion> findPostulacionesNoAceptadas() {
    EntityManager em = emf.createEntityManager();
    List<PostuladoParaAdopcion> lista = null;

    try {
        lista = em.createQuery(
            "SELECT p FROM PostuladoParaAdopcion p WHERE p.aceptado = false", 
            PostuladoParaAdopcion.class
        ).getResultList();
    } finally {
        em.close();
    }

    return lista;
}
    
    
    
}
