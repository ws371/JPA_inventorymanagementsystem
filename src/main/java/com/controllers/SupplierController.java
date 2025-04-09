package com.controllers;

import com.entities.Supplier;
import com.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    @PutMapping("/{id}")
    public void updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) {
        supplier.setSupplierId(id);
        supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable int id) {
        supplierService.deleteSupplier(id);
    }
}
