package org.example;

import java.time.LocalDate;
import org.example.dao.TaskDao;
import org.example.dao.UserDao;
import org.example.dao.impl.TaskDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.model.Status;
import org.example.model.Task;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = new User("Katie", "meow_meow@gmail.com");
        userDao.create(user);
        User user2 = userDao.findByID(1L).get();
        Task task1 = new Task("Creating project", "Creating project for portfilio", Status.IN_PROGRESS, LocalDate.parse("2026-03-05"), user2);
        Task task2 = new Task("Drawing", "Picture of Van Gogh", Status.DONE, LocalDate.parse("2026-02-22"), user);
        TaskDao taskDao = new TaskDaoImpl();
        taskDao.create(task2);
    }
}