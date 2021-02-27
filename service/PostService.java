package post.service;

import post.model.Comment;
import post.model.Post;
import post.model.User;

import java.util.List;

public interface PostService {

    void save(Post post);

    void update(Post post);

    List<Post> findAll();

    List<Post> findAllByUserId(int userId);

    Post findById(int id);

    void delete(int id);

    void deleteByUserId(int userId);
}
