package com.example.lab2.service;

import com.example.lab2.domain.Comment;
import com.example.lab2.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Override
    public List<Comment> findAll() {
        return  commentRepo.findAll();
    }

    @Override
    public void addComment(int id, Comment c) {
         // Post
    }
}
