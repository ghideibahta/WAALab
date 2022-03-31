package edu.miu.lab1.Service;

import edu.miu.lab1.domain.Post;
import edu.miu.lab1.domain.dto.PostDto;
import edu.miu.lab1.helper.ListMapper;
import edu.miu.lab1.repo.PostRepo;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToPostDto;
    @Override
    public List<PostDto> findAll() {
        //System.out.println("Service" +postRepo.findall());
        return (List<PostDto>)listMapperPostToPostDto.mapList(postRepo.findall(), new PostDto());

    }

    @Override
    public PostDto getPostById(int id) {

        return modelMapper.map(postRepo.getPostById(id), PostDto.class);
    }

    @Override
    //@Autowired
    //@Bean
    public void save(Post p) {
        //Post pd = new Post();
        //pd.setId(p.getId());
        ///pd.setTitle(p.getTitle());
        //pd.setContent(p.getContent());
        System.out.println("Service" + p);
        postRepo.save(p);



        //postRepo.save(p);
    }

    @Override
    public void deletePost(int id) {
        postRepo.deletePost(id);
    }

    @Override
    public void updatePost(int id, Post pd) {
       postRepo.updatePost(id,pd);
    }

   /* @Override
    public void delete(int id) {
        postRepo.delete(id);
    }*/

    /*@Override
    public void update(int id, Post p) {
        postRepo.update(id, p);
    }*/
}
