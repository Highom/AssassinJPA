/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package main.java.ch.bbw.yr.model.repositories;

import main.java.ch.bbw.yr.model.Entities.Job;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JobRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        em = emFactory.createEntityManager();
//        em.getTransaction().begin();
    }

    public void closeup() {
//        em.getTransaction().commit();
        if ((em != null) && em.isOpen()) {
            em.close();
        }
        if ((emFactory != null) && emFactory.isOpen()) {
            emFactory.close();
        }
    }

    public List<Job> getAllJobs() {
        List<Job> listJobs = null;
        try {
            em.getTransaction().begin();
            listJobs = em.createNamedQuery("Job.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listJobs;
    }

    public void createJob(Job emp) {
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Job readJob(int id) {
        Job Job = null;
        try {
            em.getTransaction().begin();
            Job = em.find(Job.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return Job;
    }

    public void updateJob(Job emp) {
        try {
            em.getTransaction().begin();
            Job Job = em.find(Job.class, emp.getId());
            if (Job != null) {
                em.merge(Job);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteJob(int id) {
        try {
            em.getTransaction().begin();
            Job Job = em.find(Job.class, id);
            if (Job != null) {
                em.remove(Job);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
