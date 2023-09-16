package ru.aston.khmarenko_gi.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.aston.khmarenko_gi.task4.Dao.UserDao;
import ru.aston.khmarenko_gi.task4.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMockTest {
    @Mock
    UserDao userDao;

    @InjectMocks
    UserDaoService userDaoService;

    @BeforeEach
    void initEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest() {
        User user1 = new User(1,"Ivan", "Ivanov",
                "Ivanovich", "+79993332211", "ivan@mail.ru", 1);
        User user2 = new User(1,"Igor", "Okonma",
                "Gregory", "+79001001234", "tyler_the_creator@mail.ru", 4);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        Mockito.when(userDao.findAll()).thenReturn(list);
        Assertions.assertEquals(userDaoService.findAll().get(0).getName(), "Ivan");
    }

    @Test
    public void findEntityByIdTest() {
        User user1 = new User(1,"Igor", "Okonma",
                "Gregory", "+79001001234", "tyler_the_creator@mail.ru", 4);
        Mockito.when(userDao.findEntityById(user1.getId())).thenReturn(user1);
        Assertions.assertEquals(userDaoService.findEntityById(user1.getId()).getSurname(), "Okonma");
    }

    @Test
    public void deleteTest() {
        Mockito.when(userDao.delete(2)).thenReturn(true);
        Assertions.assertTrue(userDaoService.delete(2));
    }

    @Test
    public void createTest() {
        User user1 = new User("Bogdan","Samoylov",
                "Glebovich", "+79199199911", "bogdan@gmail.com", 1);
        Mockito.when(userDao.create(user1)).thenReturn(true);
        Assertions.assertTrue(userDaoService.create(user1));
    }

    @Test
    void updateTest() {
        User user1 = new User("Bogdan","Samoylov",
                "Glebovich", "+79199199911", "bogdan@gmail.com", 1);
        User user2 = new User(2,"Valentin","Dyadka",
                "Glebovich", "+79199199911", "bogdan@gmail.com", 3);

        Mockito.when(userDao.update(user1)).thenReturn(user2);
        Assertions.assertEquals(userDaoService.update(user1).getName(), user2.getName());
    }

    @Test
    void mergeTablesTest() {
        List<String> list = new ArrayList<>();
        list.add("User_ID: " + 1
                + "; Username: " + "Bogdan"
                + "; Order_ID:" + 1
                + "; OrderName:" + "disk");
        list.add("User_ID: " + 2
                + "; Username: " + "Valentin"
                + "; Order_ID:" + 3
                + "; OrderName:" + "monitor");

        Mockito.when(userDao.mergeTables()).thenReturn(list);
        Assertions.assertEquals(userDaoService.mergeTables().get(0),
                "User_ID: 1; Username: Bogdan; Order_ID:1; OrderName:disk");
    }
}
