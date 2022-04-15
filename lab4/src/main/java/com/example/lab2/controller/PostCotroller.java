package com.example.lab2.controller;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin("http://localhost:3000/")

public class PostCotroller {

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> findAll(){

        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable("id") int id) {

        return postService.getPostById(id);

    }

    @PostMapping()
    public void save(@RequestBody Post p){
        postService.save(p);
    }


    @GetMapping("/{id}/comments")
    public List<Comment> getPostsCommentsById(@PathVariable("id") long id) {
        System.out.println("********** in controller******");
        return postService.getPostsCommentsById(id);

    }

    @GetMapping("/post/{title}")
    public List<PostDto> findPostsByTitle(@RequestParam(value="title",required = false) String title){

        return postService.findPostsByTitle(title);
    }

    @PostMapping("/addpost")
    public void addPost(@RequestBody PostDto post){
        postService.addPost(post);
    }

    @DeleteMapping("/{id}")

    public void deleteById(@PathVariable long id){
        postService.deleteById(id);
    }




}







