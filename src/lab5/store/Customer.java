package lab5.store;

 /**
  * This class represents a customer with ID.
  * @author Markus Blomqvist
  */
public class Customer {
     private int ID;

     /**
      * This constructor creates a customer with an ID.
      */
     public Customer(int number) {
         this.ID = number;
     }

     /**
      * This method returns the ID of the customer.
      */
     public int getID() {
         return ID;
     }

     /**
      * This method returns a String of the ID of the customer.
      */
     public String toString() {
         return String.valueOf(ID);
     }
 }