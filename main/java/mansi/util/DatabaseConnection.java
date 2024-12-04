package mansi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/online_banking_system";
    private static final String USER = "root";
    private static final String PASSWORD = "Science@12"; 

    // Method to get a connection to the database
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        }
        return connection;
    }

    // Main method to test the connection
    public static void main(String[] args) {
        // Test the database connection
        Connection connection = null;
        try {
            connection = getConnection();
            if (connection != null) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection.");
            }
        } finally {
            // Close the connection if it was established
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the connection: " + e.getMessage());
                }
            }
        }
    }
}
