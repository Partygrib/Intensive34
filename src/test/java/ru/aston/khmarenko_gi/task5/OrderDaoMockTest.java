package ru.aston.khmarenko_gi.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.aston.khmarenko_gi.task4.Dao.OrderDao;
import ru.aston.khmarenko_gi.task4.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoMockTest {

    @Mock
    OrderDao orderDao;

    @InjectMocks
    OrderDaoService orderDaoService;

    @BeforeEach
    void initEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest() {
        Order order1 = new Order(1, "disk", "2023-04-17");
        Order order2 = new Order(2, "monitor", "2023-08-08");
        List<Order> list = new ArrayList<>();
        list.add(order1);
        list.add(order2);
        Mockito.when(orderDao.findAll()).thenReturn(list);
        Assertions.assertEquals(orderDaoService.findAll().get(0).getName(), "disk");
    }

    @Test
    public void findEntityByIdTest() {
        Order order1 = new Order(5, "laptop", "2022-09-11");
        Mockito.when(orderDao.findEntityById(order1.getId())).thenReturn(order1);
        Assertions.assertEquals(orderDaoService.findEntityById(order1.getId()).getName(), "laptop");
    }

    @Test
    public void deleteTest() {
        Mockito.when(orderDao.delete(5)).thenReturn(true);
        Assertions.assertTrue(orderDaoService.delete(5));
    }

    @Test
    void createTest() {
        Order order1 = new Order("processor", "2021-01-13");
        Mockito.when(orderDao.create(order1)).thenReturn(true);
        Assertions.assertTrue(orderDaoService.create(order1));
    }

    @Test
    void updateTest() {
        Order order1 = new Order(2, "processor", "2021-01-13");
        Order order2 = new Order(2, "mouse", "2023-09-10");

        Mockito.when(orderDao.update(order1)).thenReturn(order2);
        Assertions.assertEquals(orderDaoService.update(order1).getName(), order2.getName());
    }
}
