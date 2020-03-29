/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.dao;

import it.marconivr.microblog.Servlet.exceptions.NonexistentEntityException;
import it.marconivr.microblog.Servlet.exceptions.PreexistingEntityException;
import it.marconivr.microblog.entity.BlogUtente;
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
 * @author Tutor
 */
public class UtenteDao implements Serializable {

 
     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MICROBLOGDB_PU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void create(BlogUtente blogUtente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(blogUtente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBlogUtente(blogUtente.getUsername()) != null) {
                throw new PreexistingEntityException("BlogUtente " + blogUtente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void edit(BlogUtente blogUtente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            blogUtente = em.merge(blogUtente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = blogUtente.getUsername();
                if (findBlogUtente(id) == null) {
                    throw new NonexistentEntityException("The blogUtente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BlogUtente blogUtente;
            try {
                blogUtente = em.getReference(BlogUtente.class, id);
                blogUtente.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The blogUtente with id " + id + " no longer exists.", enfe);
            }
            em.remove(blogUtente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static List<BlogUtente> findBlogUtenteEntities() {
        return findBlogUtenteEntities(true, -1, -1);
    }

    public static List<BlogUtente> findBlogUtenteEntities(int maxResults, int firstResult) {
        return findBlogUtenteEntities(false, maxResults, firstResult);
    }

    private static List<BlogUtente> findBlogUtenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BlogUtente.class));
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

    public static BlogUtente findBlogUtente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BlogUtente.class, id);
        } finally {
            em.close();
        }
    }

    public static int getBlogUtenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BlogUtente> rt = cq.from(BlogUtente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
