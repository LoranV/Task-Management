package org.example.dao;

import java.util.List;
import java.util.Optional;
import org.example.model.Task;

public interface TaskDao {
    Task create(Task task);
    Task update(Task user);
    Optional<Task> findByID(Long id);
    List<Task> findAll();
    boolean deleteByID(Long id);
}
