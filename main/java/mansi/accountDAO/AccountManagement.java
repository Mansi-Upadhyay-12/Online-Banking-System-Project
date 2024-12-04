package mansi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountManagement {

    public int createAccount(int userId) {
        String query = "INSERT INTO accounts (user_id, balance) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, userId);
            statement.setBigDecimal(2, new java.math.BigDecimal(0)); // Initial balance
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Return the account ID
            }
        } catch (SQLException e) {
            System.out.println("Account creation error: " + e.getMessage());
        }
        return -1; // Indicating failure
    }

    public double getBalance(int accountId) {
        String query = "SELECT balance FROM accounts WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching balance: " + e.getMessage());
        }
        return -1; // Indicating failure
    }
}
