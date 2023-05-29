package com.example.library_management.controller;

import com.example.library_management.models.Category;
import com.example.library_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<?> addCategory (@RequestBody Category category) {
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory (@PathVariable("categoryId") Long categoryId) {

        Category category = this.categoryService.getCategory(categoryId);

        if (category == null)
            return ResponseEntity.ok("Category Not found");
        else
            return ResponseEntity.ok(category);

    }


    @PutMapping("/update")
    public ResponseEntity<?> updateCategory (@RequestBody Category category) {
        return ResponseEntity.ok(this.categoryService.updateCategory(category));
    }

    @DeleteMapping("/delete")
    public void deleteCategory (@RequestBody Category category) {
        this.categoryService.deleteCategory(category);
    }

}
