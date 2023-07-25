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

    @PostMapping()
    public Post createPost(@RequestBody Post post){
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

    @GetMapping("/category/search/{id}")
    public List<Post> searchPostByCategoryId(@PathVariable Long id){
        return postService.searchPostByCategory(id);// Posts or []
    }


    @PutMapping
    public Post updatePost(@RequestBody Post post){
        return postService.update(post); // Update post or null
    }

    @GetMapping("/tags/search/")
    public List<Post> searchByTagsName(@RequestParam("tags") List<String> tagNames){
        return postService.searchPostByTags(tagNames); // Posts or []
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePost(@PathVariable Long id){
        return postService.delete(id); // HttpStatus = OK or NotFound
    }

}
