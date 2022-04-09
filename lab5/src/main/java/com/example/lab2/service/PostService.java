package com.example.lab2.service;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    void save(Post p);

    List<PostDto> findAll();
    PostDto getPostById(int id);

    List<Comment> getPostsCommentsById(long id);

    List<PostDto> findPostsByTitle(String title);


    void addPost(PostDto post);
}
