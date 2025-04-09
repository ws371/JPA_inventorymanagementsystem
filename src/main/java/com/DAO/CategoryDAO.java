package com.DAO;

import com.entities.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addCategory(Category category) {
        em.persist(category);
    }

    public Category getCategoryById(int id) {
        return em.find(Category.class, id);
    }

    public List<Category> getAllCategories() {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }

    @Transactional
    public void updateCategory(Category category) {
        em.merge(category);
    }

    @Transactional
    public void deleteCategory(int id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }
}
