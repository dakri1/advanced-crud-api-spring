package com.example.crudapi.service;


import com.example.crudapi.entity.Category;
import com.example.crudapi.repository.CategoryRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category create(Category category){
        return categoryRepo.save(category);
    }

    public List<Category> getAll(){
        return categoryRepo.findAll();
    }

    public Optional<Category> getOne(Long id){
        return categoryRepo.findById(id);
    }

    public HttpStatus delete(Long id){
        if (categoryRepo.findById(id).isPresent()){
            categoryRepo.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }
}
