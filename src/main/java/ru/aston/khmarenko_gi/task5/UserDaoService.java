package ru.aston.khmarenko_gi.task5;

import ru.aston.khmarenko_gi.task4.Dao.UserDao;
import ru.aston.khmarenko_gi.task4.Entity.User;

import java.util.List;

public class UserDaoService {
    private final UserDao userDao;

    public UserDaoService (UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findEntityById(long id) {
        return userDao.findEntityById(id);
    }

    public boolean delete(long id) {
        return userDao.delete(id);
    }

    public boolean create(User user) {
        return userDao.create(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public List<String> mergeTables() {
        return userDao.mergeTables();
    }
}
