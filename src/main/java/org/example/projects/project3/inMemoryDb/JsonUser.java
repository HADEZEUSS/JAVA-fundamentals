package org.example.projects.project3.inMemoryDb;

import org.example.projects.project3.model.User;
import org.example.projects.project3.service.UserService;

import java.util.Optional;

public class JsonUser implements UserService {

    @Override
    public User save(User user) {
        return InMemoryDatabase.saveUser(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(InMemoryDatabase.getUsers().get(id));
    }
}
