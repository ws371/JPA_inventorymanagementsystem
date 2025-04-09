package com.DAO;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Supplier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SupplierDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addSupplier(Supplier supplier) {
        try {
            em.persist(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Supplier getSupplierById(int id) {
        return em.find(Supplier.class, id);
    }

    public List<Supplier> getAllSuppliers() {
        TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s", Supplier.class);
        return query.getResultList();
    }

    @Transactional
    public void updateSupplier(Supplier supplier) {
        try {
            em.merge(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteSupplier(int id) {
        Supplier supplier = em.find(Supplier.class, id);
        if (supplier != null) {
            try {
                em.remove(supplier);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
