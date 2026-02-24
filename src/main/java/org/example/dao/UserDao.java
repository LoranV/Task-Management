package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.User;

public interface UserDao {
    User create(User user);
    User update(User user);
    Optional<User> findByID(Long id);
    List<User> findAll();
    boolean deleteByID(Long id);
}
