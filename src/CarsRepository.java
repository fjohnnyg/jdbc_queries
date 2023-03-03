import java.sql.*;
import java.util.List;

public class CarsRepository {
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    public static PreparedStatement preparedStatement = null;
    public static List<Cars> list;


    public static void createCarsTable() {
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
            Connection_DB.closeConnections(connection, statement, resultSet);
        }
        System.out.println("-".repeat(50));
    }

    public static void createCar(String brand, String model, int hourlyRate, int manufactureYear, String licensePlate) {
        try {
            // Open a connection
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            // Execute a query to insert a new car into the Cars table
            System.out.println("Inserting into Cars table...");
            String sql = "INSERT INTO Cars (brand, model, hourly_rate, manufacture_year, license_plate) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, hourlyRate);
            preparedStatement.setInt(4, manufactureYear);
            preparedStatement.setString(5, licensePlate);
            preparedStatement.executeUpdate();

            System.out.println("Car " + brand + " " + model + " created successfully");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement, resultSet);
        }
        System.out.println("-".repeat(50));
    }

    public static void getCar(int id) {
        // SELECT * FROM Cars WHERE id = ?
        try {
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Selecting from Cars table...");
            String sql = "SELECT * FROM Cars WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int hourlyRate = resultSet.getInt("hourly_rate");
                int manufactureYear = resultSet.getInt("manufacture_year");
                String licensePlate = resultSet.getString("license_plate");
                System.out.println("id: " + id + ", brand: " + brand + ", model: " + model + ", hourly rate: " + hourlyRate + ", manufacture year: " + manufactureYear + ", license plate: " + licensePlate);
            } else {
                System.out.println("There's no car with id " + id);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, preparedStatement, resultSet);
        }
        System.out.println("Goodbye!");
    }

    public static void updateCar(int id, String brand, String model, Integer hourlyRate, Integer manufactureYear, String licensePlate) {
        try {
            System.out.println("Connecting to database: " + Connection_DB.DB_URL);
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            System.out.println("Updating into Cars database...");
            statement = connection.createStatement();
            String sql = "UPDATE Cars SET brand = ?, model = ?, hourly_rate = ?, manufacture_year = ?, license_plate = ? WHERE id = ?";

            if (brand == null) {
                String temp_sql = "SELECT brand FROM Cars WHERE id = " + "'" + id + "'";
                resultSet = statement.executeQuery(temp_sql);
                if (resultSet.next()) {
                    brand = resultSet.getString("brand");
                }
            }
            if (model == null) {
                String temp_sql = "SELECT model FROM Cars WHERE id = " + "'" + id + "'";
                resultSet = statement.executeQuery(temp_sql);
                if (resultSet.next()) {
                    model = resultSet.getString("model");
                }
            }
            if (hourlyRate == null) {
                String temp_sql = "SELECT hourly_rate FROM Cars WHERE id = " + "'" + id + "'";
                resultSet = statement.executeQuery(temp_sql);
                if (resultSet.next()) {
                    hourlyRate = resultSet.getInt("hourly_rate");
                }
            }
            if (manufactureYear == null) {
                String temp_sql = "SELECT manufacture_year FROM Cars WHERE id = " + "'" + id + "'";
                resultSet = statement.executeQuery(temp_sql);
                if (resultSet.next()) {
                    manufactureYear = resultSet.getInt("manufacture_year");
                }
            }
            if (licensePlate == null) {
                String temp_sql = "SELECT license_plate FROM Cars WHERE id = " + "'" + id + "'";
                resultSet = statement.executeQuery(temp_sql);
                if (resultSet.next()) {
                    licensePlate = resultSet.getString("license_plate");
                }
            }

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, hourlyRate);
            preparedStatement.setInt(4, manufactureYear);
            preparedStatement.setString(5, licensePlate);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            System.out.println("Car " + id + " updated successfully");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            Connection_DB.closeConnections(connection, statement, resultSet);
        }
        System.out.println("-".repeat(50));
    }

    void   deleteCar() {
        // DELETE FROM Customers WHERE id = ?
    }

    List<Cars> getCustomers() {
        // SELECT * FROM Customers
        return null;
    }
}
