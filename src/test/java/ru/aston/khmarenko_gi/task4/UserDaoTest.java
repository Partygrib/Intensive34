package ru.aston.khmarenko_gi.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.khmarenko_gi.task4.Dao.UserDao;
import ru.aston.khmarenko_gi.task4.Entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoTest {
    private static UserDao userDao;

    @BeforeAll
    static void Init() throws SQLException {
        Connection connection = Connector.getConnection();
        Statement stmp = connection.createStatement();
        stmp.execute("RUNSCRIPT FROM 'classpath:scripts/db.sql'");
        stmp.execute("RUNSCRIPT FROM 'classpath:scripts/insert.sql'");
        userDao = new UserDao();
    }

    @Test
    public void findAllTest() {
        List<User> list = userDao.findAll();
        Assertions.assertEquals(list.get(0).getName(), "Ivan");
    }

    @Test
    public void findEntityByIdTest() {
        Assertions.assertEquals(userDao.findEntityById(4).getSurname(), "Okonma");
    }

    @Test
    public void deleteTest() {
        Assertions.assertTrue(userDao.delete(1));
    }

    @Test
    void create() {
        Assertions.assertTrue(userDao.create(new User("Bogdan","Samoylov",
                "Glebovich", "+79199199911", "bogdan@gmail.com", 1)));
    }

    @Test
    void update() {
        User user = new User(2,"Valentin","Dyadka",
                "Glebovich", "+79199199911", "bogdan@gmail.com", 3);
        Assertions.assertEquals(userDao.update(user).getName(), "Valentin");
        Assertions.assertEquals(userDao.findEntityById(2).getName(), "Valentin");
    }

    @Test
    void mergeTablesTest() {
        Assertions.assertEquals(userDao.mergeTables().get(1),
                "User_ID: 2; Username: Gleb; Order_ID:3; OrderName:laptop");
    }
}