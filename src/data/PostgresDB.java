package data;
import data.interfaces.IDB;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDB implements IDB {
    Connection connection = null;
    Statement statement = null;
    try {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourdatabase", "username", "password");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        // create table dishes
        String sqlDishes = "CREATE TABLE dishes " +
                "(id INT PRIMARY KEY     NOT NULL," +
                " name           TEXT    NOT NULL, " +
                " price          REAL    NOT NULL)";
        try {
            statement.executeUpdate(sqlDishes);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Table 'dishes' created successfully");

        // Establish the connection
        Connection con = DriverManager.getConnection(connectionUrl, "postgres", "91926499");

        return con;
    } catch (Exception e) {
        System.out.println(e);
        return null;
    }
}
}