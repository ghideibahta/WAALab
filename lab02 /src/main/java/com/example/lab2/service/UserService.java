package com.example.lab2.service;


import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(User u);
    List<UserDto> findAll();
    UserDto getUserById(long id);
    //List<PostDto> getPostsById(long id);

    List<PostDto> getUserPostById(long id);
}
