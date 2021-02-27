package post.service;

import post.model.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);

    void update(Comment comment);

    List<Comment> findAll();

    List<Comment> findAllByPostId(int postId);

    void delete(int id);

    void deleteByPostId(int postId);

    void deleteByUserId(int userId);
}
