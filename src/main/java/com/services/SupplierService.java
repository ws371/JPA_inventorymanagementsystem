package com.services;

import com.DAO.SupplierDAO;
import com.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierDAO supplierDAO;

    @Autowired
    public SupplierService(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    public void addSupplier(Supplier supplier) {
        supplierDAO.addSupplier(supplier);
    }

    public Supplier getSupplierById(int id) {
        return supplierDAO.getSupplierById(id);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    public void updateSupplier(Supplier supplier) {
        supplierDAO.updateSupplier(supplier);
    }

    public void deleteSupplier(int id) {
        supplierDAO.deleteSupplier(id);
    }
}
