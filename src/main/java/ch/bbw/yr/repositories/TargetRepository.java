/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.repositories;

import ch.bbw.yr.entities.Target;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TargetRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public TargetRepository() {
        setup();
    }

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
            flushAndClear();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Object readTarget(int id) {
        Object Target = null;
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
            Object Target = em.find(Target.class, emp.getId());
            if (Target != null) {
                em.merge(Target);
                flushAndClear();
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
            Object target = em.find(Target.class, id);
            if (target != null) {
                em.remove(target);
                flushAndClear();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    private void flushAndClear() {
        em.flush();
        em.clear();
    }
}
