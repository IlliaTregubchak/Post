package post.service;

import post.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void update(User user);

    List<User> findAll();

    User findById(int id);

    void delete(int id);
}
