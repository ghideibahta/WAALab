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
    public void save(User u) {
        userRepo.save(u);

    }

    @Override
    public List<UserDto> findAll() {

        return (List<UserDto>)listMapperDto.mapList( userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.getUserById(id), UserDto.class);

    }

   /* @Override
    public List<PostDto> getPostsById(long id){
        return (List<PostDto>) listMapperpostDto.mapList(userRepo.getPostsById(id),new PostDto());
    }*/

    @Override
    public List<PostDto> getUserPostById(long id) {
        return (List<PostDto>) listMapperpostDto.mapList(userRepo.getPostsByUserId(id), new PostDto());

    }
}





