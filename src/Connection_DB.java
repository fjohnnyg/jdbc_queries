import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection_DB {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/CarRentals";
    public static final String USER = "root";
    public static final String PASS = "secret";

    public static void closeConnections(Connection connection, Statement statement) {
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
