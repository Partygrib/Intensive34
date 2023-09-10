package ru.aston.khmarenko_gi.task4.Dao;
import ru.aston.khmarenko_gi.task4.Connector;
import ru.aston.khmarenko_gi.task4.Entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements DaoDataEntityLayer<Order>{
    private final Connection connection;
    private static final String SQL_SELECT_ALL_ORDERS = "SELECT * FROM db1.orders";
    private static final String SQL_SELECT_ORDER_BY_ID = "SELECT * FROM db1.orders WHERE id = ?";
    private static final String SQL_DELETE_ORDER_BY_ID = "DELETE FROM db1.orders WHERE id = ?";
    private static final String SQL_CREATE_ORDER = "INSERT INTO db1.orders (name, order_date)" +
            "VALUES (?,?)";
    private static final String SQL_UPDATE_ORDER_BY_ID = "UPDATE db1.orders SET name = ?, order_date = ?" +
            " WHERE id = ?";

    public OrderDao() throws SQLException {
        this.connection = Connector.getConnection();
    }
    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ORDERS);
            while (resultSet.next()){
                orderList.add(new Order(resultSet.getLong(1),
                        resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order findEntityById(long id) {
        Order order = null;
        try (PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ORDER_BY_ID)){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                order = new Order(resultSet.getLong(1),
                        resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return order;
    }

    @Override
    public boolean delete(long id) {
        boolean isDelete = false;
        try(PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ORDER_BY_ID)){
            statement.setLong(1, id);
            if (statement.executeUpdate() > 0){
                isDelete = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    @Override
    public boolean create(Order order) {
        boolean isCreate = false;
        try(PreparedStatement statement = connection.prepareStatement(SQL_CREATE_ORDER)){
            statement.setString(1, order.getName());
            statement.setString(2, order.getDate());
            if (statement.executeUpdate() > 0){
                isCreate = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isCreate;
    }

    @Override
    public Order update(Order order) {
        Order resultOrder = null;
        try(PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ORDER_BY_ID)) {
            statement.setString(1, order.getName());
            statement.setString(2, order.getDate());
            statement.setLong(3, order.getId());
            if (statement.executeUpdate() > 0){
                resultOrder = findEntityById(order.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultOrder;
    }
}
