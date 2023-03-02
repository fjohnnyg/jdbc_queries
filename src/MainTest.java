import java.sql.*;

public class MainTest {
    static final String DB_URL = "jdbc:mysql://localhost/CarRentals";
    static final String USER = "root";
    static final String PASS = "secret";
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query to create a table
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();
            String sql = "CREATE TABLE Customers " +
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) UNIQUE NOT NULL," +
                    "PRIMARY KEY (id))";

            statement.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            closeConnections(connection, statement);
        }
        System.out.println("Goodbye!");
    }

    private static void closeConnections(Connection connection, Statement statement) {
        try {
            if (statement != null)
                connection.close();
        } catch (SQLException se) {
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
