package com.example.lab2.repo;

import com.example.lab2.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {


    void addComment(int id, Comment c);
}
