package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {


    List<Post> findAll();

    Post getPostById(long id);

    User getUserById(long userId);
    //public void deletePost(long id);



}
