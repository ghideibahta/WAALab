package com.example.lab2.repo;

import com.example.lab2.domain.Comment;
import com.example.lab2.domain.Post;
import com.example.lab2.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {


    List<Post> findAll();

    Post getPostById(long id);

    @Query(value="select p.comments from Post p where p.id=:id")
    List<Comment> getPostsCommentsById(long id);

    //@Query(value="select p.title from Post p where p.title=:title")
   // List<Post> findByTitle(@Param("title") String title);
    List<Post> findPostsByTitle(String title);

    void deleteById(long id);

}
