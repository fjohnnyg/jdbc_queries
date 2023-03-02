import java.sql.*;
import java.util.List;
public class CustomerRepository {
    static Connection connection = null;
    static Statement statement = null;

    static void createCustomer(String name, String email) {
        try {
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Inserting into Customers database...");
            statement = connection.createStatement();
            String sql = "INSERT INTO Customers (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Customer created successfully");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("Goodbye!");
    }

    Customer  getCustomer(int id) {
        // SELECT * FROM Customers WHERE id = ?
        return null;
    }

    Customer  updateCustomer(Customer customer) {
        // UPDATE Customers SET name = ?, phone_number = ?, email = ? WHERE id = ?
        return null;
    }

    void   deleteCustomer(int id) {
        // DELETE FROM Customers WHERE id = ?
    }

    List<Customer> getCustomers() {
        // SELECT * FROM Customers
        return null;
    }
}
