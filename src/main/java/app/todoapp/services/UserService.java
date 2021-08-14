package app.todoapp.services;

import app.todoapp.models.User;

import java.util.List;

public interface UserService {

    public User create(User user);

    public List<User> all();

    public User getById(Long id);

    public User update(Long id, User newUser);

    public void delete(Long id);
}
