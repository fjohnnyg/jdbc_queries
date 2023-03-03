import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerRepository.createCustomer("Alice Brown", "alice.brown@example.com");
        CustomerRepository.createCustomer("Bob Johnson", "bob.johnson@example.com");
        CustomerRepository.createCustomer("Charlie Lee", "charlie.lee@example.com");
        CustomerRepository.createCustomer("David Chen", "david.chen@example.com");
        CustomerRepository.createCustomer("Emily Davis", "emily.davis@example.com");
        CustomerRepository.createCustomer("Frank Garcia", "frank.garcia@example.com");
        CustomerRepository.createCustomer("Grace Kim", "grace.kim@example.com");
        CustomerRepository.createCustomer("Henry Nguyen", "henry.nguyen@example.com");
        CustomerRepository.createCustomer("Isabella Rivera", "isabella.rivera@example.com");
        CustomerRepository.createCustomer("Jake Smith", "jake.smith@example.com");

        CustomerRepository.getCustomers();


    }
}
