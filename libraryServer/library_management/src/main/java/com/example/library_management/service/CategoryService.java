package com.example.library_management.service;

import com.example.library_management.models.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory (Category category);

    public Category getCategory (Long categoryId);

    public Category updateCategory (Category category);

    public void deleteCategory (Category category);


}
