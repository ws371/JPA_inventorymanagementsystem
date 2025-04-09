package com.controllers;

import com.entities.Product;
import com.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        service.addProduct(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Product product) {
        product.setProductId(id);
        service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteProduct(id);
    }
}