package post.service.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import post.config.DatabaseConfig;
import post.model.Post;
import post.model.User;
import post.service.CommentService;
import post.service.PostService;
import post.util.Constants;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class PostServiceImpl implements PostService {

    private Dao<Post, Integer> dao;
    private CommentService commentService;

    {
        commentService = new CommentServiceImpl();
        try{
            ConnectionSource source = new JdbcConnectionSource(Constants.URL);
            dao = DaoManager.createDao(source, Post.class);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Post post) {
        post.setDate(LocalDateTime.now().toString());
        try {
            dao.createIfNotExists(post);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Post post) {
        try {
            dao.update(post);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Post> findAll() {
        try {
            final List<Post> posts = dao.queryForAll();
//            posts.forEach(s -> {
//                User user = userService.findById(s.getUserId());
//                user.getName()
//            });
            return posts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // select * from posts where userId = ?
    public List<Post> findAllByUserId(int userId) {
        try{
            return dao.queryBuilder()
                    .where()
                    .eq("user_id", userId)
                    .query();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // select * from posts where id = ?;
    public Post findById(int id) {
        try{
           return dao.queryForId(id);
//            return dao.queryBuilder()
//                    .where()
//                    .eq("id", id)
//                    .queryForFirst();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void delete(int id) {
        try{
            // видалення всіх коментів якогось поста
            commentService.deleteByPostId(id);
            // видаляємо сам пост
            dao.deleteById(id);
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
