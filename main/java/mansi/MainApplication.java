package mansi;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManagement userManagement = new UserManagement();
        AccountManagement accountManagement = new AccountManagement();
        TransactionManagement transactionManagement = new TransactionManagement();

        // Main application loop
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading integer

            switch (choice) {
                case 1:
                    handleRegistration(scanner, userManagement);
                    break;

                case 2:
                    handleLogin(scanner, userManagement, accountManagement, transactionManagement);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close(); // Close scanner when exiting the program
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the main menu
    private static void showMainMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    // Handle user registration
    private static void handleRegistration(Scanner scanner, UserManagement userManagement) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (userManagement.registerUser(username, password, email)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }
    }

    // Handle user login and account management
    private static void handleLogin(Scanner scanner, UserManagement userManagement,
                                     AccountManagement accountManagement, TransactionManagement transactionManagement) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userManagement.loginUser(username, password)) {
            System.out.println("Login successful!");
            int userId = userManagement.getUserId(username);
            int accountId = accountManagement.createAccount(userId);
            System.out.println("Account created with ID: " + accountId);

            handleAccountActions(scanner, accountManagement, transactionManagement, accountId);
        } else {
            System.out.println("Login failed.");
        }
    }

    // Handle actions related to account management (Deposit, Withdraw, etc.)
    private static void handleAccountActions(Scanner scanner, AccountManagement accountManagement,
                                              TransactionManagement transactionManagement, int accountId) {
        while (true) {
            showAccountMenu();
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    handleDeposit(scanner, transactionManagement, accountId);
                    break;

                case 2:
                    handleWithdrawal(scanner, transactionManagement, accountId);
                    break;

                case 3:
                    checkBalance(accountManagement, accountId);
                    break;

                case 4:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }

    // Display the account menu
    private static void showAccountMenu() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Logout");
    }

    // Handle deposit action
    private static void handleDeposit(Scanner scanner, TransactionManagement transactionManagement, int accountId) {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        if (transactionManagement.deposit(accountId, depositAmount)) {
            transactionManagement.recordTransaction(accountId, depositAmount, "DEPOSIT");
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit failed.");
        }
    }

    // Handle withdrawal action
    private static void handleWithdrawal(Scanner scanner, TransactionManagement transactionManagement, int accountId) {
        // Assuming getBalance() method exists to fetch the current account balance.
        double currentBalance = transactionManagement.getBalance(accountId);
        
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
    
        // Validate if the withdrawal amount is greater than the current balance
        if (withdrawAmount > currentBalance) {
            System.out.println("Error: Insufficient funds. You have only " + currentBalance + " in your account.");
        } else {
            // Proceed with the withdrawal if there are enough funds
            if (transactionManagement.withdraw(accountId, withdrawAmount)) {
                transactionManagement.recordTransaction(accountId, withdrawAmount, "WITHDRAWAL");
                System.out.println("Withdrawal successful! New balance: " + (currentBalance - withdrawAmount));
            } else {
                System.out.println("Withdrawal failed.");
            }
        }
    }
3    

    // Check balance in the account
    private static void checkBalance(AccountManagement accountManagement, int accountId) {
        double balance = accountManagement.getBalance(accountId);
        if (balance != -1) {
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Error fetching balance.");
        }
    }
}