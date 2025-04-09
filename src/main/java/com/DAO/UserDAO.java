package com.DAO;

import com.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        try {
            em.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Transactional
    public void updateUser(User user) {
        try {
            em.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            try {
                em.remove(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
