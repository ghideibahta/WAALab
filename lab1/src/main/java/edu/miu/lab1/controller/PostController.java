package edu.miu.lab1.controller;

import edu.miu.lab1.Service.PostService;
import edu.miu.lab1.domain.Post;
import edu.miu.lab1.domain.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

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

        System.out.println(p.getId());//"Controller" + p);
        postService.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") int id){
        postService.deletePost(id);
    }

   @PutMapping ("/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody Post pd){
        postService.updatePost(id, pd);
    }






}
