import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            getCustomers().forEach(System.out::println);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static Connection getConnection() {
//
//        String dbURL = "jdbc:mysql://localhost:3306/CarRentals";
//        String username = "root";
//        String password = "secret";
//        Connection connection = null;
//
//        try {
//            connection = DriverManager.getConnection(dbURL, username, password);
//        } catch (SQLException ex) {
//            System.out.println("Connection failed: " + ex.getMessage());
//        }
//
//        return connection;
//    }
//
//
//    public static List<Customer> getCustomers() throws SQLException {
//
//        List<Customer> customers = new LinkedList<>();
//
//        Connection connection = getConnection();
//        // CREATING A STATEMENT
//        Statement statement = connection.createStatement();
//
//        // CREATIING A QUERY
//        String query = "SELECT * FROM Customers";
//
//        // EXECUTING THE QUERY
//        ResultSet resultSet = statement.executeQuery(query);
//
//        // DEALING WITH THE RESULTS
//        while (resultSet.next()) {
//            String firstName = resultSet.getString("name");
//            String phone_number = resultSet.getString("phone_number");
//            String email = resultSet.getString("email");
//
//            customers.add(new Customer(firstName, phone_number, email));
//
//
//        }
//        return customers;
    }
}
