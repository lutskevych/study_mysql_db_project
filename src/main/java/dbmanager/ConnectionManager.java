package dbmanager;

import org.aeonbits.owner.ConfigFactory;
import utils.DataBaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;
    private static DataBaseProperties dbProperties;

    private static void setConnection() {
        try {
            dbProperties = ConfigFactory.create(DataBaseProperties.class);
            connection = DriverManager.getConnection(
                    dbProperties.url(),
                    dbProperties.user(),
                    dbProperties.password());
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
