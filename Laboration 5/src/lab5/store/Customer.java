package lab5.store;

public class Customer {
  private int ID;
  private CustomerState state;
  
  public Customer(int number) {
    this.ID = number;
  }
  
  public int getID(){
    return ID;
  }
  
  public String toString(){
    return String.valueOf(ID);
  }
  
  public CustomerState getState(){
    return state;
  }
  
  public void setState(CustomerState state){
    this.state = state;
  }
}
