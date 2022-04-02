package com.example.lab2;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.repo.PostRepo;
import com.example.lab2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Lab2Application {

    public static void main(String[] args) {

        SpringApplication.run(Lab2Application.class, args);
        /*ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Lab2Application.class, args);
        UserRepo userRepo = configurableApplicationContext.getBean(UserRepo.class);
        PostRepo postRepo = configurableApplicationContext.getBean(PostRepo.class);
        //List<Post> p = new ArrayList<>();
        User u1 = new User(2, "Rahel", p);
        Post post1 = new Post(100, "Moon", "nature", "Dave", u1);
        Post post2 = new Post(101, "coming back", "family reunion", "Zahra", u1);
        postRepo.save(post1);
        postRepo.save(post2);
        p = Arrays.asList(post1, post2);
        //User user = new User(post1);
        // userRepo.save(user); */

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
