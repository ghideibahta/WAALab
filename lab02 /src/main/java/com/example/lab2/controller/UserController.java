package com.example.lab2.controller;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.service.PostService;
import com.example.lab2.service.UserService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable ("id") long id){
        return userService.findById(id);
    }
    @PostMapping()
    public void saveUser(@RequestBody User user){
        userService.addUser(user);
    }
    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUser(@PathVariable("id") long id){
        return userService.getPostsForUser(id);
    }
    @GetMapping("/filter")
    public List<User> getMoreThanOne(){
        return userService.getUsersPostsGreaterThanOne();
    }



}



