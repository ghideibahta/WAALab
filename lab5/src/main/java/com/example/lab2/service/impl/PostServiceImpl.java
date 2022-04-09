package com.example.lab2.service.impl;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.service.PostService;
import com.example.lab2.util.ListMapper;
import com.example.lab2.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper<Post, PostDto> listMapperDto;

    @Autowired
    ListMapper<Post, PostDto> listMapperTitle;



    @Override
    public void save(Post p) {
        postRepo.save(p);

    }

    @Override
    public List<PostDto> findAll() {

        return (List<PostDto>)listMapperDto.mapList( postRepo.findAll(), new PostDto());
    }
    public PostDto getPostById(int id) {

        return modelmapper.map(postRepo.getPostById(id), PostDto.class);

    }

    @Override
    public void addPost(PostDto postDto){
        postRepo.save(modelmapper.map(postDto, Post.class));
    }

    public List<Comment> getPostsCommentsById(@PathVariable("id") long id) {
        System.out.println("********** in controller******");
        PostServiceImpl userService;
        return postRepo.getPostsCommentsById(id);

    }


    @Override
    public List<PostDto> findPostsByTitle(String title) {
        return (List<PostDto>) listMapperTitle.mapList(postRepo.findPostsByTitle(title), new PostDto());
    }

}

