package web.service;

import web.models.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void update(int id, User user);
    void delete(int id);
}
