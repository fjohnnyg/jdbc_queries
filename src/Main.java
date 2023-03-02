import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer.createCustomerTable();
        Cars.createCarsTable();
        Rentals.createRentalsTable();


    }
}
