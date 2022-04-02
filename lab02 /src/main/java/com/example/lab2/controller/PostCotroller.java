package com.example.lab2.controller;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostCotroller {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> findAll(){

        return postService.findAll();
    }

    @GetMapping("/{id}")

    public PostDto getPostById(@PathVariable("id") int id) {

        return postService.getPostById(id);

    }

    @PostMapping()
    public void save(@RequestBody Post p){
        postService.save(p);
    }

   /*@DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
    }*/

    /*@PutMapping ("/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody Post pd){
        postService.updatePost(id, pd);
    }*/

}







