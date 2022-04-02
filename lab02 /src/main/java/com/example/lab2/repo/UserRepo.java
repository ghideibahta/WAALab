package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {


   List<User> findAll();

    User getUserById(long id);
    List<Post> getPostsById(long id);

    @Query(value = "select u.posts from User  u where u.id=:id" )
    List<Post> getPostsByUserId(long id);
}
