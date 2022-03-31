package edu.miu.lab1.Service;

import edu.miu.lab1.domain.Post;
import edu.miu.lab1.domain.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();
    PostDto getPostById(int id);
    void save(Post p);
    void deletePost(int id);
    void updatePost(int id, Post pd);


}
