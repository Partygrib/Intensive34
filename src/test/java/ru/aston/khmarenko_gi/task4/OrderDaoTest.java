package ru.aston.khmarenko_gi.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.khmarenko_gi.task4.Dao.OrderDao;
import ru.aston.khmarenko_gi.task4.Entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderDaoTest {
    private static OrderDao orderDao;

    @BeforeAll
    static void Init() throws SQLException {
        Connection connection = Connector.getConnection();
        Statement stmp = connection.createStatement();
        stmp.execute("RUNSCRIPT FROM 'classpath:scripts/db.sql'");
        stmp.execute("RUNSCRIPT FROM 'classpath:scripts/insert.sql'");
        orderDao = new OrderDao();
    }

    @Test
    public void findAllTest() {
        List<Order> list = orderDao.findAll();
        Assertions.assertEquals(list.get(0).getName(), "disk");
    }

    @Test
    public void findEntityByIdTest() {
        Assertions.assertEquals(orderDao.findEntityById(3).getName(), "laptop");
    }

    @Test
    public void deleteTest() {
        Assertions.assertTrue(orderDao.delete(5));
    }

    @Test
    void create() {
        Assertions.assertTrue(orderDao.create(new Order("Processor", "2021-01-13")));
    }

    @Test
    void update() {
        Order order = new Order(2, "mouse", "2023-09-10");
        Assertions.assertEquals(orderDao.update(order).getName(), "mouse");
        Assertions.assertEquals(orderDao.findEntityById(2).getName(), "mouse");
    }
}