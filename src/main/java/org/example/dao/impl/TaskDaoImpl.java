package org.example.dao.impl;

import java.util.List;
import java.util.Optional;
import org.example.dao.TaskDao;
import org.example.model.Task;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TaskDaoImpl implements TaskDao {
    @Override
    public Task create(Task task) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
            System.out.println("Task created successfully");
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Unable to save user, transaction has been rolled back");
                transaction.rollback();
            }
        }
        return task;
    }

    @Override
    public Task update(Task user) {
        return null;
    }

    @Override
    public Optional<Task> findByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public boolean deleteByID(Long id) {
        return false;
    }
}
