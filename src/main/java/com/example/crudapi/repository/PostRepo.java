package com.example.crudapi.repository;

import com.example.crudapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAll();
    List<Post> findByCategoryId(Long id);

    List<Post> findByTagsNameIn(List<String> tags);


}
