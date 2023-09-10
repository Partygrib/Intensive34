package ru.aston.khmarenko_gi.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {
    private static Connection connection;

    private Connector() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
