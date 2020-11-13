/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package main.java.ch.bbw.yr.model.repositories;

import main.java.ch.bbw.yr.model.Entities.Target;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TargetRepository {
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

    public List<Target> getAllTargets() {
        List<Target> listTargets = null;
        try {
            em.getTransaction().begin();
            listTargets = em.createNamedQuery("Target.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listTargets;
    }

    public void createTarget(Target emp) {
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Target readTarget(int id) {
        Target Target = null;
        try {
            em.getTransaction().begin();
            Target = em.find(Target.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return Target;
    }

    public void updateTarget(Target emp) {
        try {
            em.getTransaction().begin();
            Target Target = em.find(Target.class, emp.getId());
            if (Target != null) {
                em.merge(Target);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteTarget(int id) {
        try {
            em.getTransaction().begin();
            Target Target = em.find(Target.class, id);
            if (Target != null) {
                em.remove(Target);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
