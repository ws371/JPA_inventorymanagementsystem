package com.controllers;

import com.entities.Category;
import com.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setCategoryId(id);
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
