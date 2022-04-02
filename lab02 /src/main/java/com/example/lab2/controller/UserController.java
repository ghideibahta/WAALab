package com.example.lab2.controller;

import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.service.PostService;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    /*@Autowired
    PostService postService;*/

    @GetMapping()
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public void save(@RequestBody User u) {
        userService.save(u);

    }

   @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsUser(@PathVariable long id) {
        return userService.getPostsById(id);
    }

}



