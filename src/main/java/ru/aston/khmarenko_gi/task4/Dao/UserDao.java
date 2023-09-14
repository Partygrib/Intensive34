package ru.aston.khmarenko_gi.task4.Dao;
import ru.aston.khmarenko_gi.task4.Connector;
import ru.aston.khmarenko_gi.task4.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DaoDataEntityLayer<User>{
    private final Connection connection;
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM db1.users";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM db1.users WHERE id = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM db1.users WHERE id = ?";
    private static final String SQL_CREATE_USER = "INSERT INTO db1.users (name, surname, middle_name, " +
            "number, email, order_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE db1.users " +
            "SET name = ?, surname = ?, middle_name = ?, number = ?, email = ?, order_id = ?" +
            "WHERE id = ?";

    private static final String SQL_SELECT_USERS_JOIN_ORDERS
            = "SELECT db1.users.id, db1.users.name, db1.orders.id, db1.orders.name FROM db1.users " +
            "JOIN db1.orders ON db1.orders.id = db1.users.order_id";

    public UserDao() throws SQLException {
        this.connection = Connector.getConnection();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()){
                users.add(new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getLong(7)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User findEntityById(long id) {
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getLong(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean delete(long id) {
        boolean isDelete = false;
        try(PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_BY_ID)) {
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
    public boolean create(User user) {
        boolean isCreate = false;
        try(PreparedStatement statement = connection.prepareStatement(SQL_CREATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getMiddleName());
            statement.setString(4, user.getNumber());
            statement.setString(5, user.getEmail());
            statement.setLong(6, user.getOrderId());
            if (statement.executeUpdate() > 0){
                isCreate = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isCreate;
    }

    @Override
    public User update(User user) {
        User resultUser = null;
        try(PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getMiddleName());
            statement.setString(4, user.getNumber());
            statement.setString(5, user.getEmail());
            statement.setLong(6, user.getOrderId());
            statement.setLong(7, user.getId());
            if (statement.executeUpdate() > 0){
                resultUser = findEntityById(user.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultUser;
    }

    public List<String> mergeTables() {
        List<String> listJoin = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USERS_JOIN_ORDERS);
            while (resultSet.next()){
                listJoin.add("User_ID: " +resultSet.getString(1)
                        + "; Username: " + resultSet.getString(2)
                        + "; Order_ID:" + resultSet.getString(3)
                        + "; OrderName:" + resultSet.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listJoin;
    }
}
