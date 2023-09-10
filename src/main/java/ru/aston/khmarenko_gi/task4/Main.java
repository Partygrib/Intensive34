package ru.aston.khmarenko_gi.task4;
import ru.aston.khmarenko_gi.task4.Dao.OrderDao;
import ru.aston.khmarenko_gi.task4.Entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] argv) {
        Connection connection;

        try {
            connection = Connector.getConnection();
            Statement stmp = connection.createStatement();
            stmp.execute("RUNSCRIPT FROM 'classpath:scripts/db.sql'");
            stmp.execute("RUNSCRIPT FROM 'classpath:scripts/insert.sql'");

            OrderDao orderDao = new OrderDao();
            List<Order> list = orderDao.findAll();
            System.out.println(list);

            connection.close();
            stmp.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
    }
}
