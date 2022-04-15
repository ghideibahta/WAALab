package com.example.lab2.service;

import com.example.lab2.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();
    
    void addComment(int id, Comment c);
}
