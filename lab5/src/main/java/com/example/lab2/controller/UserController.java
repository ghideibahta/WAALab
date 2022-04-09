package com.example.lab2.controller;

import com.example.lab2.aspect.annotation.ExecutionTime;
import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.service.PostService;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @RolesAllowed("USER")
    @GetMapping("/*")
    public List<User> findAll() {
        return userService.findAll();
    }


    @PostMapping()
    public void save(@RequestBody User u) {
        userService.save(u);

    }
    @RolesAllowed({"USER","ADMIN"})
    @ExecutionTime
   @GetMapping("/admin/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return userService.getUserById(id);
    }


    @DeleteMapping("/{id}/users")
    public void  deleteById(@PathVariable("id") long id){

        userService.deleteById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getUserPostsById(@PathVariable("id") long id) {
        System.out.println("********** in controller******");
        return userService.getUserPostsById(id);

    }

    @PostMapping("/{id}/*")
    public void addPost(@PathVariable long id, @RequestBody Post post){
        System.out.println("#####UserController");
        userService.addPost(id,post);

    }


    @GetMapping("/{n}/more")
    public List<User> findAllUsersHaveMoreThan(@PathVariable int n){

        return userService.findAllUsersHaveMoreThan(n);
    }






}



