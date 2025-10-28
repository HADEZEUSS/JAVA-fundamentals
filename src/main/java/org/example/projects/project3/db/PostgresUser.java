package org.example.projects.project3.db;

import org.example.projects.project3.model.User;
import org.example.projects.project3.service.UserService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class PostgresUser implements UserService {

    private final DataSource ds;

    public PostgresUser(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public User save(User user) {
        if (user.getUserId() == null) {
            // Insert and get generated ID
            String sql = "INSERT INTO users(username, email) VALUES (?, ?) RETURNING user_id";
            try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getEmail());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        user.setUserId(rs.getLong(1));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to save new user", e);
            }
        } else {
            // Upsert if ID exists
            String sql = "INSERT INTO users(user_id, username, email) VALUES (?, ?, ?) " + "ON CONFLICT (user_id) DO UPDATE SET username = EXCLUDED.username, email = EXCLUDED.email";
            try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setLong(1, user.getUserId());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getEmail());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Failed to update existing user", e);
            }
        }
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "SELECT user_id, username, email FROM users WHERE user_id = ?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User(rs.getLong("user_id"), rs.getString("username"), rs.getString("email"));
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user", e);
        }
        return Optional.empty();
    }
}
