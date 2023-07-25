package com.example.crudapi.service;


import com.example.crudapi.entity.Tag;
import com.example.crudapi.repository.TagRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepo tagRepo;

    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public Tag create(Tag tag){
        return tagRepo.save(tag);
    }

    public List<Tag> getAll(){
        return tagRepo.findAll();
    }

    public Optional<Tag> getOne(Long id){
        return tagRepo.findById(id);
    }

    public HttpStatus delete(Long id){
        if (tagRepo.findById(id).isPresent()){
            try {
                tagRepo.deleteById(id);
                return HttpStatus.OK;
            }catch(Exception e) {
                return HttpStatus.BAD_REQUEST;
            }


        }
        return HttpStatus.NOT_FOUND;
    }

}
