package post.start;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import post.config.DatabaseConfig;
import post.model.Comment;
import post.model.Post;
import post.model.User;
import post.service.CommentService;
import post.service.PostService;
import post.service.UserService;
import post.service.impl.CommentServiceImpl;
import post.service.impl.PostServiceImpl;
import post.service.impl.UserServiceImpl;
import post.util.Constants;

import java.sql.SQLException;

public class AppManager extends Application {

//    private Dao<User, Integer> userDao;
//    private Dao<Post, Integer> postDao;
//    private Dao<Comment, Integer> commentDao;
//
//    private UserService userService;
//    private PostService postService;
//    private CommentService commentService;
//
//    {
//        userService = new UserServiceImpl();
//        postService = new PostServiceImpl();
//        commentService = new CommentServiceImpl();
//
//        try{
//            ConnectionSource source = new JdbcConnectionSource(Constants.URL);
//            userDao = DaoManager.createDao(source, User.class);
//            postDao = DaoManager.createDao(source, Post.class);
//            commentDao = DaoManager.createDao(source, Comment.class);
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseConfig.connect();
        String screen;
        screen = "/view/Main.fxml";

        Parent root = FXMLLoader.load(getClass().getResource(screen));
        primaryStage.setTitle("Main Window");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DatabaseConfig.close();
    }
}
