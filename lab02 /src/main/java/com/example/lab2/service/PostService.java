package com.example.lab2.service;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    void save(Post p);

    List<PostDto> findAll();
    PostDto getPostById(int id);

    //void deletePost(long id);
   /* void updatePost(int id, Post pd);


    List<PostDto> findAll();*/



}
