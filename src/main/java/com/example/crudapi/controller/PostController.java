package com.example.crudapi.controller;

import com.example.crudapi.entity.Post;
import com.example.crudapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post create(@RequestBody Post post){
        return postService.createPost(post); // Post or null
    }
    @GetMapping
    public List<Post> getAll (){
        return postService.getAllPosts(); // Posts or null
    }

    @GetMapping("/{id}")
    public Optional<Post> getOne(@PathVariable Long id){
        return postService.getOnePost(id); // Post or null
    }

    @PutMapping
    public Post updatePost(@RequestBody Post post){
        return postService.update(post); // Update post or null
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePost(@PathVariable Long id){
        return postService.delete(id); // HttpStatus = OK or NotFound
    }

}
