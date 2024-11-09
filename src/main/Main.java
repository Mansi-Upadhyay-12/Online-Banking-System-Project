package main;
import dao.UserDAO;
import model.User; 
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create a new user and add it to the database
        User user = new User("William Anderson", "william@example.com", "password567");
        userDAO.addUser(user);
        System.out.println("User added!");

        // Retrieve user details to verify the addition
        User retrievedUser = userDAO.getUserByEmail("william@example.com");
        if (retrievedUser != null) {
            System.out.println("User found: " + retrievedUser.getName());
        } else {
            System.out.println("User not found.");
        }
    }
}
