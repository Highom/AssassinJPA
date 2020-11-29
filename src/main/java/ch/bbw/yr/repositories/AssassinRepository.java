/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.repositories;


import ch.bbw.yr.Entities.Assassin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AssassinRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public AssassinRepository() {
        setup();
    }

    public void setup() {
        emFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        em = emFactory.createEntityManager();
    }

    public void closeup() {
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
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Object readAssassin(int id) {
        Object Assassin = null;
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
            Object Assassin = em.find(Assassin.class, emp.getId());
            if (Assassin != null) {
                em.merge(Assassin);
                em.flush();
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
            Object Assassin = em.find(Assassin.class, id);
            if (Assassin != null) {
                em.remove(Assassin);
                em.flush();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
