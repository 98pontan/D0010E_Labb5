package lab5.store;

 /**
  * This class represents a customer with ID.
  * @author Markus Blomqvist
  */
public class Customer {
     private final int ID;
     private double queueTime = 0;

    public void setQueueTime(double queueTime)
    {
       this.queueTime = queueTime;
    }

    /**
      * This constructor creates a customer with an ID.
      */
     public Customer(int number)
     {
         this.ID = number;
     }

    /**
     * @return the ID of the customer
     */
     public int getID()
     {
         return ID;
     }

     /**
      * @return a string of the ID of the customer.
      */
     public String toString()
     {
         return String.valueOf(ID);
     }


    public double getQueueTime(double time)
    {
       queueTime = time - queueTime;
       return queueTime;
    }
 }