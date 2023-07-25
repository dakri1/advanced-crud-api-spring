package com.example.crudapi.controller;


import com.example.crudapi.entity.Tag;
import com.example.crudapi.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post/tags")
public class TagsController {
    private final TagService tagService;

    public TagsController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag tag){
        return tagService.create(tag); // Tag
    }

    @GetMapping
    public List<Tag> getAllTags(){
        return tagService.getAll(); // Tags or []
    }

    @GetMapping("/{id}")
    public Optional<Tag> getOneTag(@PathVariable Long id){
        return tagService.getOne(id); // Tag or null
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTag(@PathVariable Long id){
        return tagService.delete(id); // HttpStatus = OK or BAD_REQUEST or NOT_FOUND
    }
}
