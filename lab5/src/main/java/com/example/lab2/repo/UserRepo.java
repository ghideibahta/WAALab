package com.example.lab2.repo;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import com.example.lab2.domain.dto.UserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {


   List<User> findAll();

    User getUserById(long id);
    List<Post> getPostsById(long id);

    User findByEmail(String username);

   @Query(value = "select u.posts from User u where u.id=:id" )
    List<Post> getUserPostsById(long id);

    @Query(value = "select u.posts from User u where u.posts.size>:n" )

    List<User> findAllUsersHaveMoreThan(int n);




}
