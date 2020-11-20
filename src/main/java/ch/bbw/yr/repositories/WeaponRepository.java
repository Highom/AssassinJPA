/**
 * @Author: Yannick Ruck
 * @Date: 07/11/2020
 */
package ch.bbw.yr.repositories;

import ch.bbw.yr.Entities.Weapon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class WeaponRepository {
    private EntityManagerFactory emFactory;
    private EntityManager em;

    public WeaponRepository() {
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

    public List<Weapon> getAllWeapons() {
        List<Weapon> listWeapons = null;
        try {
            em.getTransaction().begin();
            listWeapons = em.createNamedQuery("Weapon.findAll").getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listWeapons;
    }

    public void createWeapon(Weapon emp) {
        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }

    }

    public Weapon readWeapon(int id) {
        Weapon weapon = null;
        try {
            em.getTransaction().begin();
            weapon = em.find(Weapon.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return weapon;
    }

    public void updateWeapon(Weapon emp) {
        try {
            em.getTransaction().begin();
            Weapon weapon = em.find(Weapon.class, emp.getId());
            if (weapon != null) {
                em.merge(weapon);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void deleteWeapon(int id) {
        try {
            em.getTransaction().begin();
            Weapon weapon = em.find(Weapon.class, id);
            if (weapon != null) {
                em.remove(weapon);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
