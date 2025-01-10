# Online Banking System Project

## Description
The Online Banking System is a secure and user-friendly platform that allows users to manage their bank accounts online. This system supports user registration, login, and basic banking operations like transferring money and viewing transaction history. The project uses Java, MySQL, and web technologies like HTML, CSS, and JSP.

## Features
- **User Registration**: Users can create new accounts.
- **Login System**: Secure login for registered users.
- **Money Transfer**: Users can transfer funds between accounts.
- **Transaction History**: Users can view their recent transactions.
- **Profile Management**: Users can update their personal details.

## Technologies Used

### Frontend:
- HTML
- CSS (Bootstrap)
- JavaScript

### Backend:
- Java (JDK)
- Servlets
- JSP (Java Server Pages)

### Database:
- MySQL
- JDBC (Java Database Connectivity)

### Version Control:
- Git & GitHub
- ## Setup Instructions

### 1. Prerequisites
Before you begin, make sure you have the following installed:
- **Java Development Kit (JDK)**
- **MySQL** (for database)
- **Apache Tomcat** (for running Servlets and JSP)
- **IDE** (e.g., Eclipse, IntelliJ IDEA, or Visual Studio Code)

### 2. Clone the Repository
Clone the repository to your local machine using Git:
```bash
git clone https://github.com/Mansi-Upadhyay-12/Online-Banking-System-Project.git
```
2. **Set Up MySQL Database:**
   - Install and start MySQL.
   - Create a new database for the project:
     ```sql
     CREATE DATABASE online_banking_system;
     ```
   - Import any provided SQL files to create the required tables (users, accounts, transactions).

3. **Import Project into Your IDE:**
   - Open your Java IDE (e.g., IntelliJ IDEA, Eclipse).
   - Import the project as a **Maven Project**.

4. **Configure MySQL Connection:**
   - Find and update the database connection details (username, password, database URL) in the project's configuration files.

5. **Build the Project:**
   - Open a terminal in the project directory and run:
     ```bash
     mvn clean install
     ```

6. **Run the Application:**
   - To start the application, run the following command:
     ```bash
     mvn tomcat9:run
     ```
   - Access the application in your browser at `http://localhost:8080/online_banking`.

---
## 3. Unit Testing

Unit tests are used to check if different parts of the application work correctly. This project uses **JUnit** for testing.

### Running Unit Tests:
- To run the tests, use this command:
  ```bash
  mvn test
