package com.example.crudapi.service;

import com.example.crudapi.entity.Post;
import com.example.crudapi.repository.PostRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Post createPost(Post post){
            return postRepo.save(post);
    }
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public Optional<Post> getOnePost(Long id){
            return postRepo.findById(id);
        }

    public Post update(Post post){
        if (postRepo.findById(post.getId()).isPresent()){
            return postRepo.save(post);
        }
        return null;
    }

    public List<Post> searchPostByCategory(Long id){
        return postRepo.findByCategoryId(id);
    }

    public List<Post> searchPostByTags(List<String> tags){
        return postRepo.findByTagsNameIn(tags);
    }

    public HttpStatus delete(Long id){
        if (postRepo.findById(id).isPresent()){
            postRepo.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }
}
