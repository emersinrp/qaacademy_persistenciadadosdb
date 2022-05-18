package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {
        String serverName = "localhost";
        String portNumber = "5432";
        String sid = "postgres";
        String url = "jdbc:postgresql://" + serverName + ":" + portNumber + "/" + sid;
        String userName = "postgres";
        String password = "34421452e";

        return DriverManager.getConnection(url, userName, password);
    }
}
