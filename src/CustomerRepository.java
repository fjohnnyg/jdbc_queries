import java.sql.*;
import java.util.List;
public class CustomerRepository {
    static Connection connection = null;
    static Statement statement = null;

    static void createCustomer(String name, String email) {
        try {
            System.out.println("Connecting to database CarRentals: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Inserting into Customers table...");
            statement = connection.createStatement();
            String sql = "INSERT INTO Customers (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();

            System.out.println("Customer " + name + " created successfully");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("-".repeat(50));
    }

    public static void getCustomer(int id) {
        try {
            System.out.println("Connecting to database CarRentals: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);
            System.out.println("Selecting from the Customers table...");

            statement = connection.createStatement();
            String sql = "SELECT id, name, email FROM Customers WHERE id = ?";
            PreparedStatement tempStatement = connection.prepareStatement(sql);
            tempStatement.setInt(1, id);
            ResultSet resultSet = tempStatement.executeQuery();

            while (resultSet.next()) {
                int customerId = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                String customerEmail = resultSet.getString("email");
                System.out.println("Customer " + customerId + " is " + customerName + " with email " + customerEmail);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("-".repeat(50));
    }


    public static void updateCustomer(int id, String name, String email) {
        // UPDATE Customers SET name = ?, phone_number = ?, email = ? WHERE id = ?
        try {
            String oldName = null;
            String oldEmail = null;

            System.out.println("Connecting to database CarRentals: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Updating into Customers table...");
            statement = connection.createStatement();
            String sql = "UPDATE Customers SET name = ?, email = ? WHERE id = ?";

            String original_Name_And_Email = "SELECT name, email FROM Customers WHERE id = ?";
            PreparedStatement oldValuesCheck = connection.prepareStatement(original_Name_And_Email);
            oldValuesCheck.setInt(1, id);

            ResultSet oldValueResult = oldValuesCheck.executeQuery();

            while (oldValueResult.next()) {
                oldName = oldValueResult.getString("name");
                oldEmail = oldValueResult.getString("email");

            }

            if (name.equals("null")) {
                String originalName = "SELECT name FROM Customers WHERE id = ?";
                PreparedStatement tempStatement = connection.prepareStatement(originalName);
                tempStatement.setInt(1, id);

                ResultSet resultSet =tempStatement.executeQuery();

                while (resultSet.next()) {
                    String customerName = resultSet.getString("name");
                    name = customerName;
                }

            }
            if (email.equals("null")) {
                String originalEmail = "SELECT email FROM Customers WHERE id = ?";
                PreparedStatement tempStatement = connection.prepareStatement(originalEmail);
                tempStatement.setInt(1, id);

                ResultSet resultSet =tempStatement.executeQuery();

                while (resultSet.next()) {
                    String customerEmail = resultSet.getString("email");
                    email = customerEmail;

                }

            }

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Customer " + id + " updated successfully");
            System.out.println("Old name = " + oldName );
            System.out.println("Current name = " + name);
            System.out.println("Old email = " + oldEmail );
            System.out.println("Current email = " + email);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("-".repeat(50));
    }

    void   deleteCustomer(int id) {
        // DELETE FROM Customers WHERE id = ?
    }

    public static void getCustomers() {
        // SELECT * FROM Customers
        try {
            System.out.println("Connecting to database CarRentals: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Selecting from Customers table...");
            statement = connection.createStatement();
            String sql = "SELECT id, name, email FROM Customers";
            PreparedStatement tempStatement = connection.prepareStatement(sql);
            ResultSet resultSet = tempStatement.executeQuery();

            while (resultSet.next()) {
                int customerId = resultSet.getInt("id");
                String customerName = resultSet.getString("name");
                String customerEmail = resultSet.getString("email");
                System.out.println("Customer " + customerId + " is " + customerName + " with email " + customerEmail);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement);
        }
        System.out.println("-".repeat(50));
    }


}
