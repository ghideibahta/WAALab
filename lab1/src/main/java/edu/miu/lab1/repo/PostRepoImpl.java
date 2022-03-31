package edu.miu.lab1.repo;

import edu.miu.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class PostRepoImpl implements PostRepo {

    private static List<Post> post;
    private  static long id = 500;

    static {
        post = new ArrayList<>();

        Post p2 = new Post(1, "Sunday fall", "about nature", "Betty");
        Post p3 = new Post(2, "Moon", "related to dreams", "Ahmed");
        Post p1 = new Post(4, "sisters", "family relation", "Daniela");
        post.add(p1);
        post.add(p2);
        post.add(p3);
    }

    @Override
    public List<Post> findall() {
        return post;
    }

    @Override
    public Post getPostById(int id) {
        return post
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse((null));
    }

    @Override
    public void save(Post p) {
        //id++;
        p.setId(id);
        id++;
        System.out.println("Repo.." + p);

        post.add(p);

    }

    @Override
    public void deletePost(int id) {
        post.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(post::remove);
    }

    @Override
    public void updatePost(int id, Post pd) {
        Post newupdate = getPostById(id);
        newupdate.setTitle(pd.getTitle());
        newupdate.setContent(pd.getContent());
        newupdate.setAuthor(pd.getAuthor());
    }


}
