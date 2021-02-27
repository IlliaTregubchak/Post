package post.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnUser;

    @FXML
    private Button btnPost;

    @FXML
    private Button btnComment;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnUser.setOnAction(s -> openUser());
        btnPost.setOnAction(s -> openPost());
        btnComment.setOnAction(s -> openComment());
    }

    private void openUser() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/User.fxml"));
            btnUser.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openPost() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Post.fxml"));
            btnPost.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openComment() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Comment.fxml"));
            btnComment.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
