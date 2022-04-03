package com.example.lab2.controller;


import com.example.lab2.domain.Comment;
import com.example.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    CommentService commentService;


    public List<Comment> findAll(){

        return commentService.findAll();
    }

    @PutMapping("/{id}")
    public void addComment(@PathVariable("id") int id, @RequestBody Comment c){
        commentService.addComment(id, c);
    }

}
