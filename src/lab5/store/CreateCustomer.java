package lab5.store;

public class CreateCustomer {
  private int createdCustomers = 0;
  
  public Customer createCustomer(){
    Customer customer = new Customer(createdCustomers);
    createdCustomers++;
    return customer;
  }
}
