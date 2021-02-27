package post.service.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import post.model.User;
import post.service.CommentService;
import post.service.PostService;
import post.service.UserService;
import post.util.Constants;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    // створили ссилку на дао, 1 - тип данних обєкта, для якого створ DAO, 2 - тип данних його id
    private Dao<User, Integer> dao;
    private PostService postService;
    private CommentService commentService;

    {
        commentService = new CommentServiceImpl();
        postService = new PostServiceImpl();
        try {
            // заміняє нам цілий клас DatabaseConfig
            ConnectionSource source = new JdbcConnectionSource(Constants.URL);
            // DaoManager - вбудований клас в бібл ORM Light, який має стат метод createDAO, який створ dao
            // на основі джерела до БД і класу, на основі якого створ dao
            // звертаємось як до userDAO
            dao = DaoManager.createDao(source, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(User user) {
        try {
//            dao.create(user);
            // метод з дод перевіркою
            // якшо id обєкта існує в БД, то тоді не створиться
            // якшо не існує, то створиться
            dao.createIfNotExists(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            // дао бере id обєкта, якшо воно існує ми робимо update, якшо немає, то ми його створюємо
//            dao.createOrUpdate(user);
            dao.update(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> findAll() {
        try {
           return dao.queryForAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // select * from users where id = ?;
    public User findById(int id) {
        try{
            // QB дає можливість розширити SQL-запит за допомогою методів
           return dao.queryBuilder()
                    .where()
                   // id = ?;
                    .eq("id", id)
                   // закриває builder i повертає 1-й знайдений елемент
                    .queryForFirst();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void delete(int id) {
        try {
            commentService.deleteByUserId(id);
            postService.deleteByUserId(id);
            dao.deleteById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
