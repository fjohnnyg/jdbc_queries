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

    public static void getCustomer(int id) {
        // SELECT * FROM Customers WHERE id = ?
        //TODO
        try {
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Selecting from Customers database...");
            statement = connection.createStatement();
            String sql = "SELECT * FROM Customers WHERE id = " + "'" + id + "'";
            statement.executeUpdate(sql);
            System.out.println("Customer " + id + " is" + statement.executeUpdate(sql));
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("Goodbye!");

    }

    public static void updateCustomer(int id, String name, String email) {
        // UPDATE Customers SET name = ?, phone_number = ?, email = ? WHERE id = ?
        try {
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Updating into Customers database...");
            statement = connection.createStatement();
            String sql = "UPDATE Customers SET name = ?, email = ? WHERE id = ?";

            //TODO
            if (name.equals("null")) {
                String originalName = "SELECT name FROM Customers WHERE id = ?";
                PreparedStatement tempStatement = connection.prepareStatement(originalName);
                tempStatement.setInt(1, id);
                tempStatement.executeUpdate();
                name = originalName;
            }
            if (email.equals("null")) {
                String originalEmail = "SELECT email FROM Customers WHERE id = ?";
                PreparedStatement tempStatement = connection.prepareStatement(originalEmail);
                tempStatement.setInt(1, id);
                tempStatement.executeUpdate();
                email = originalEmail;
            }
            //TODO

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Customer " + id + " updated successfully");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("Goodbye!");
    }

    void   deleteCustomer(int id) {
        // DELETE FROM Customers WHERE id = ?
    }

    List<Customer> getCustomers() {
        // SELECT * FROM Customers
        return null;
    }


}
