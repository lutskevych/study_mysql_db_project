package dbmanager;

import utils.DbProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {
    private static DbProperties dbProperties = new DbProperties();
    public static Connection connection;

    private static void setConnection() {
        try {
            connection = DriverManager.getConnection(
                    dbProperties.getUrl(),
                    dbProperties.getUserName(),
                    dbProperties.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) setConnection();
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
