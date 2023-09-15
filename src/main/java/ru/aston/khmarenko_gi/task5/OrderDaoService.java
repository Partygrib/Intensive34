package ru.aston.khmarenko_gi.task5;

import ru.aston.khmarenko_gi.task4.Dao.OrderDao;
import ru.aston.khmarenko_gi.task4.Entity.Order;

import java.util.List;

public class OrderDaoService {
    private final OrderDao orderDao;

    public OrderDaoService (OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public Order findEntityById(long id) {
        return orderDao.findEntityById(id);
    }

    public boolean delete(long id) {
        return orderDao.delete(id);
    }

    public boolean create(Order order) {
        return orderDao.create(order);
    }

    public Order update(Order order) {
        return orderDao.update(order);
    }
}
