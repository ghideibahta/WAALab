package com.example.lab2.repo;

import com.example.lab2.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {


   List<Comment> findAll();



}
