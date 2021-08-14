package app.todoapp.services.impl;

import app.todoapp.models.User;
import app.todoapp.repositories.UserRepository;
import app.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> all() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User update(Long id, User newUser) {
        User user = getById(id);
        user.setName(newUser.getName());
        user.setLogin(newUser.getLogin());
        user.setPassword(newUser.getPassword());
        user.setCreatedAt(newUser.getCreatedAt());
        user.setUpdatedAt(newUser.getUpdatedAt());

        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
