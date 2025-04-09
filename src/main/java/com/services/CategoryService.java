package com.services;

import com.DAO.CategoryDAO;
import com.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }
}
