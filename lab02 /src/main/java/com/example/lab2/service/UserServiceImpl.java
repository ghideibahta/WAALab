package com.example.lab2.service;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import com.example.lab2.helper.ListMapper;
import com.example.lab2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;



    @Autowired
    ListMapper<User, UserDto> listMapperDto;

    @Autowired
    ListMapper<Post, PostDto> listMapperpostDto;




    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapperDto.mapList( userRepo.findAll(), new UserDto());
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<Post> getPostsForUser(long id) {
        User user = userRepo.findById(id);
        return user.getPosts();


    }

    @Override
    public List<User> getUsersPostsGreaterThanOne() {
        return userRepo.getUsersPostsGreaterThanOne();
    }
}



