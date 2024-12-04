package mansi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagement {

    public boolean deposit(int accountId, double amount) {
        String query = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Deposit error: " + e.getMessage());
            return false;
        }
    }

    public boolean withdraw(int accountId, double amount) {
        String query = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, amount);
            statement.setInt(2, accountId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Withdrawal error: " + e.getMessage());
            return false;
        }
    }

    public void recordTransaction(int accountId, double amount, String transactionType) {
        String query = "INSERT INTO transactions (account_id, amount, transaction_type) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountId);
            statement.setDouble(2, amount);
            statement.setString(3, transactionType);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Transaction recording error: " + e.getMessage());
        }
    }
}