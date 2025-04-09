package com.DAO;

import com.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addProduct(Product product) {
        try {
            em.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(int id) {
        return em.find(Product.class, id);
    }

    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Transactional
    public void updateProduct(Product product) {
        try {
            em.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteProduct(int id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            try {
                em.remove(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
