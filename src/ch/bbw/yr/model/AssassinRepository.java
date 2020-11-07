/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AssassinRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("MyPersistanceUnit");
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

    public List<Assassin> getAllAssassins() {
        List<Assassin> listAssassins = null;
        try {
            em.getTransaction().begin();
            listAssassins = em.createNamedQuery("Assassin.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listAssassins;
    }

    public void createAssassin(Assassin emp) {
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Assassin readAssassin(int id) {
        Assassin Assassin = null;
        try {
            em.getTransaction().begin();
            Assassin = em.find(Assassin.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return Assassin;
    }

    public void updateAssassin(Assassin emp) {
        try {
            em.getTransaction().begin();
            Assassin Assassin = em.find(Assassin.class, emp.getId());
            if (Assassin != null) {
                em.merge(Assassin);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteAssassin(int id) {
        try {
            em.getTransaction().begin();
            Assassin Assassin = em.find(Assassin.class, id);
            if (Assassin != null) {
                em.remove(Assassin);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
