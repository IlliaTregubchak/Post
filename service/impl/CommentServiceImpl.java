package post.service.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import post.model.Comment;
import post.model.Post;
import post.model.User;
import post.service.CommentService;
import post.service.PostService;
import post.service.UserService;
import post.util.Constants;

import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    private Dao<Comment, Integer> dao;
    private UserService userService;
    private PostService postService;

    {
        userService = new UserServiceImpl();
        postService = new PostServiceImpl();

        try{
            ConnectionSource source = new JdbcConnectionSource(Constants.URL);
            dao = DaoManager.createDao(source, Comment.class);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Comment comment) {
        if (comment == null) {
            throw new NullPointerException("Comment is NULL");
        }

        if (null == comment.getUserId()) {
            throw new NullPointerException("UserId is NULL");
        }

        final User user = userService.findById(comment.getUserId());

        if(user == null) {
            throw new NullPointerException("User not found");
        }

        if(null == comment.getPostId()) {
            throw new NullPointerException("Post id is NULL");
        }

        final Post post = postService.findById(comment.getPostId());

        if(post == null) {
            throw new NullPointerException("Post not found");
        }

        try {
            dao.createIfNotExists(comment);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Comment comment) {
        try {
            dao.update(comment);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Comment> findAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // select * from comments where postId = ?
    public List<Comment> findAllByPostId(int postId) {
        try{
           return dao.queryBuilder()
                    .where()
                    .eq("post_id", postId)
                    .query();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // delete from comments where id = ?
    public void delete(int id) {
        try{
            dao.deleteById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // delete from comments where post_id = ?
    // видалення всіх коментарів, які мають postId
    public void deleteByPostId(int postId) {
        try{
            dao.deleteBuilder().where().eq("post_id", postId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteByUserId(int userId) {
        try{
            dao.deleteBuilder().where().eq("user_id", userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
