package com.example.lab2.repo;

import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import com.example.lab2.domain.dto.PostDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends CrudRepository<User, Long> {


   /* List<User> findAll();

    User getUserById(long id);

    List<Post> getPostsById(long id);

    @Query(value = "select u.posts from User  u where u.id=:id")
    List<Post> getPostsByUserId(long id);


    @Query("select u.posts from User u where u.posts.size > 1")
    public List<User> getUsersPostsGreaterThanOne();*/


    public List<User> findAll();
    public User findById(long id);

    @Query("SELECT u from User u where u.name =:name")
    public List<User> getUsersByName(@Param("name") String name);

    @Query ("select u from User u where u.posts.size > 1")
    public List<User> getUsersPostsGreaterThanOne();



}
