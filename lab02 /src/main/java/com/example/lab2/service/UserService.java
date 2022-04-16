package com.example.lab2.service;


import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();
    public User findById (long id);
    public void addUser(User user);
    public List<Post> getPostsForUser(long id);
    public List<User> getUsersPostsGreaterThanOne();
}




