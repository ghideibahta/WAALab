package edu.miu.lab1.repo;

import edu.miu.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo {

    List<Post> findall();
    Post getPostById(int id);
    void save(Post p);

    void deletePost(int id);
    void updatePost(int id, Post pd);
}
