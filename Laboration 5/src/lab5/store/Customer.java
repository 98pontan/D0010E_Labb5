package lab5.store;

public class Customer {
  private int ID;
  private CustomerState state;
  
  public Customer(int number) {
    this.ID = number;
  }
  
  public getID(){
    return ID;
  }
  
  public toString(){
    return String.valueOf(ID);
  }
  
  public CustomerState getState(){
    return state;
  }
  
  public void setState(CustomerState state){
    this.state = state;
  }
  
  public class enum CustomerState {
    TURNED_AWAY, LATE_CUSTOMER, IN_STORE, NOT_IN_STORE
  }
}
