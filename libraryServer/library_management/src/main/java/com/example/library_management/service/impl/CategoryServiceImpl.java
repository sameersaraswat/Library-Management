package com.example.library_management.service.impl;

import com.example.library_management.models.Category;
import com.example.library_management.repo.CategoryRepository;
import com.example.library_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long categoryId) {
        try {
            Category category = this.categoryRepository.findById(categoryId).get();
            return category;
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Category Not Found");
            return null;
        }
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        this.categoryRepository.delete(category);
    }
}
