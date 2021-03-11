package lab5.store;

 /**
  * Creates customers and automatically increases the
  * number of customers created.
  *
  * @author Pontus Eriksson Jirbratt,
  * @author Lucas Pettersson,
  * @author Jesper Johansson Oskarsson,
  * @author Markus Blomqvist
  */
public class CreateCustomer {
  private int createdCustomers = 0;
  
 /**
  * Creates a customer with an ID of the number of customers created.
  *
  * @return customer object
  */
  public Customer createCustomer() {
    Customer customer = new Customer(createdCustomers);
    createdCustomers++;
    return customer;
  }
}
