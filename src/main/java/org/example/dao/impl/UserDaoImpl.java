package org.example.dao.impl;

import java.util.List;
import java.util.Optional;
import org.example.dao.UserDao;
import org.example.model.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            System.out.println("User created successfully");
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Unable to save user, transaction has been rolled back");
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public User update(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                System.out.println("Unable to update data, transaction has been rolled back");
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public Optional<User> findByID(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(User.class, id));
        }
    }

    @Override
    public List<User> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT * FROM User").list();
        }
    }

    @Override
    public boolean deleteByID(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                System.out.println("Unable to delete user, transaction has been rolled back");
                transaction.rollback();
                return false;
            }
        }
        return true;
    }
}
