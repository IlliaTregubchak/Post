package post.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static post.util.Constants.URL;

public class DatabaseConfig {
    // connection - клас, який тримає підключення до БД
    // робимо його статичним, щоб кожного разу піжключалися до існуючого connection
    public static Connection connection;

    // створюємо connection за допомогою DriverManagera
    // DriverManager присвоює connection до БД у змінну connection
    public static void connect() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // закриваємо connection
    public static void close() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
