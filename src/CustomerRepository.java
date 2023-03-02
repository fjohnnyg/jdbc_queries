import java.util.List;
public class CustomerRepository {

    void createCustomer(Customer customer) {
        // INSERT INTO Customers (name, phone_number, email) VALUES (?,?,?)
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
