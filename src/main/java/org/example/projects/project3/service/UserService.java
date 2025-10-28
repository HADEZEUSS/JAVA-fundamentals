package org.example.projects.project3.service;

import org.example.projects.project3.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findById(Long id);
}
