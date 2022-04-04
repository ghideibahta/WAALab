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
import org.springframework.web.bind.annotation.RequestBody;

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
    public User getUserById(long id) {
        //return modelMapper.map(userRepo.getUserById(id), UserDto.class);
        return userRepo.getUserById(id);
    }

    @Override
    public List<PostDto> getPostsById(long id){
        return (List<PostDto>) listMapperpostDto.mapList(userRepo.getPostsById(id),new PostDto());
    }

    @Override
    public List<PostDto> getUserPostsById(long id) {
        return (List<PostDto>) listMapperpostDto.mapList(userRepo.getUserPostsById(id), new PostDto());

    }

    @Override
    public void deleteById(long id) {
       userRepo.deleteById(id);
    }

    @Override
    public List<User> findAllUsersHaveMoreThan(int n) {
        return userRepo.findAllUsersHaveMoreThan(n);
    }

    @Override
    public void addPost(long id, Post post) {
        
            User user = userRepo.getUserById(id);
            List<Post> posts = user.getPosts();
            posts.add(modelMapper.map(post, Post.class));
            user.setPosts(posts);
            System.out.println(user);
            userRepo.save(user);

        }



}





