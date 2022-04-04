package com.example.lab2.service;


import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    void save(User u);
    List<UserDto> findAll();
    User getUserById(long id);
    List<PostDto> getPostsById(long id);
    List<PostDto> getUserPostsById( long id);

    void deleteById(long id);


    List<User> findAllUsersHaveMoreThan(int n);

    void addPost(long id, Post post);
}
