package com.example.lab2.service;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.helper.ListMapper;
import com.example.lab2.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper<Post, PostDto> listMapperDto;



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



    }

