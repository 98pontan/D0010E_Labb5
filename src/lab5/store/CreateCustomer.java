package lab5.store;

 /**
  * This class creates customers and automatically increases the
  * number of customers created.
  * @author Markus Blomqvist
  */
public class CreateCustomer {
  private int createdCustomers = 0;
  
 /**
  * This constructor creates a customer with an ID of the number of customers created.
  * The constructor also returns a customer.
  */
  public Customer createCustomer() {
    Customer customer = new Customer(createdCustomers);
    createdCustomers++;
    return customer;
  }
}
