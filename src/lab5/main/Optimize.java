package lab5.main;
import java.util.Random;
import lab5.events.StartEvent;
import lab5.events.ClosingEvent;
import lab5.events.StopEvent;
import lab5.sim.*;
import lab5.store.StoreState;

/**
 * This class is used to optimize the operations of a simulated environment.
 * It runs simulations to find the optimal amount of checkouts while the other parameters is set.
 * @author Markus Blomqvist.
 */
public class Optimize {
  public static void main(String[] args) {
    Optimize opt = new Optimize();
    long SEED = 315354808530047762;
    System.out.println(opt.metod2(SEED));
  }
  
  public int metod1(long SEED, int CHECKOUTS, , int MAX_CUSTOMERS,
                   double lowerGather, double upperGather, double ARRIVAL_TIME,
                   double lowerRegister, double upperRegister,  double SIM_TIME){
    
    // Kanske ska skapa en SimState model istället? Kanske fråga om detta?
    // I lab5 dokumentet: "Viktigt är att den generella simulatorn inget vet om den specifika."
    // "Den ska fungera för vilken specifik simulator som helst, inte bara en snabbköpssimulator."
    StoreState model = new StoreState(
            SEED,
            CHECKOUTS,
            MAX_CUSTOMERS,
            ARRIVAL_SPEED,
            lowerGather, upperGather,
            lowerRegister, upperRegister);
    
    EventQueue queue = new EventQueue();
    queue.addEvent(new StopEvent(model, queue));
    queue.addEvent(new ClosingEvent(model, queue, SIM_TIME));
    queue.addEvent(new StartEvent(model, queue));
    
    Simulator sim = new Simulator(model, queue);
    sim.run();
    
    return model.getMissedCustomers();
  }
  
  public int metod2(long SEED){
    // The first method's parameters.
    int MAX_CUSTOMERS = 6;
    double SIM_TIME = 10;
    double ARRIVAL_TIME = 1;
    double lowerGather = 0.5;
    double upperGather = 0.9;
    double lowerRegister = 2;
    double upperRegister = 4;
    
    // The minimal amount of checkouts can not be bigger than MAX_CUSTOMERS.
    int minCheckouts = MAX_CUSTOMERS;
    
    // Initial value of missedCustomers.
    int missedCustomers = metod1(long SEED, int CHECKOUTS, , int MAX_CUSTOMERS,
                                 double lowerGather, double upperGather, double ARRIVAL_TIME,
                                 double lowerRegister, double upperRegister,  double SIM_TIME);
    
    // Gets a new value as long as minCheckouts >= 1.
    while(minCheckouts >= 1){
      // Creates a new amount of missed customers.
      int newMissedCustomers = metod1(long SEED, int minCheckouts, , int MAX_CUSTOMERS,
                                      double lowerGather, double upperGather, double ARRIVAL_TIME,
                                      double lowerRegister, double upperRegister,  double SIM_TIME);
      
      // Checks if NewMissedCustomers is different than the inital value.
      // If it is different the last amount of checkouts was the most opmtimal amount.
      if(missedCustomers != newMissedCustomers){
        return minCheckouts + 1;
      }
      
      // Decreases the amount of minCheckouts.
      minCheckouts--;
    }
    
    return MAX_CUSTOMERS;
  }
  
  public int metod3(long SEED){
    // Sets a random seed number.
    Random rand = new Random(SEED);
    
    int maxMinCheckouts = 0;
    int counter = 0;
    int checkBigger;
    
    // Runs 100 times if the maximum of the minimum number of checkouts has not changed.
    while(counter < 100){
      int newAmountOfCheckouts = metod2(rand.nextLong());
      
      // If true, the counter resets.
      if(maxMinCheckouts != (checkBigger = maxMinCheckouts > newAmountOfCheckouts ? newAmountOfCheckouts : maxMinCheckouts)){
        counter = 0;
      }
      else{
        counter++;
      }
      
      maxMinCheckouts = (checkBigger = maxMinCheckouts > newAmountOfCheckouts ? newAmountOfCheckouts : maxMinCheckouts);
    }
    
    return maxMinCheckouts;
  }
}
