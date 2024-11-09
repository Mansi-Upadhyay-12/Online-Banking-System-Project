package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
    // Method to add a new user to the database
    public void addUser(User user) {
        String checkEmailQuery = "SELECT COUNT(*) FROM User WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkEmailQuery)) {
            checkStmt.setString(1, user.getEmail());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Email already exists.");
                return; // Prevent adding duplicate
            }
    
            // Proceed with insertion if email does not exist
            String insertQuery = "INSERT INTO User (name, password, email) VALUES (?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, user.getName());
                insertStmt.setString(2, user.getPassword());
                insertStmt.setString(3, user.getEmail());
                insertStmt.executeUpdate();
                System.out.println("User added!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Method to get a user by email
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM User WHERE email = ?";
        User user = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

