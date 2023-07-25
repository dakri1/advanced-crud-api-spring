package com.example.crudapi.controller;


import com.example.crudapi.entity.Category;
import com.example.crudapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.create(category); // Category
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAll(); // Categories or []
    }

    @GetMapping("/{id}")
    public Optional<Category> getOneCategory(@PathVariable Long id){
        return categoryService.getOne(id); // Category or null
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategory(@PathVariable Long id){
        return categoryService.delete(id); // HttpStatus = OK or NOT_FOUND
    }

}
