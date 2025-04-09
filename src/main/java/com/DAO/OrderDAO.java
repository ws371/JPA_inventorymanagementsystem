package com.DAO;

import com.entities.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addOrder(Order order) {
        em.persist(order);
    }

    public Order getOrderById(int id) {
        return em.find(Order.class, id);
    }

    public List<Order> getAllOrders() {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    @Transactional
    public void updateOrder(Order order) {
        em.merge(order);
    }

    @Transactional
    public void deleteOrder(int id) {
        Order order = em.find(Order.class, id);
        if (order != null) {
            em.remove(order);
        }
    }
}
