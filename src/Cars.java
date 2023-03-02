import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Cars {

    public static void createCarsTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            // Open a connection
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            // Execute a query to create a table
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();
            String sql = "CREATE TABLE Cars " +
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    "brand VARCHAR(255), " +
                    "model VARCHAR(255) NOT NULL," +
                    "hourly_rate INT UNIQUE NOT NULL," +
                    "manufacture_year YEAR NOT NULL," +
                    "license_plate VARCHAR(255) UNIQUE NOT NULL," +
                    "PRIMARY KEY (id))";

            statement.executeUpdate(sql);
            System.out.println("Table Cars created successfully");
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
