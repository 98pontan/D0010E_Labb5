package lab5.main;
import java.util.Random;
import sim.SimState;

public class Optimize {
  public static void main(String[] args) {
    Optimize opt = new Optimize();
    long seed = 0;
    System.out.println(opt.metod2(seed));
  }
  
  public int metod1(long SEED, int CHECKOUTS, , int MAX_CUSTOMERS,
                   double lowerGather, double upperGather, double ARRIVAL_TIME,
                   double lowerRegister, double upperRegister,  double SIM_TIME){
    
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
    
    return model; //sluttillståndet ska returneras
  }
  
  public int metod2(long SEED){
    
  }
  
  public int metod3(){
    
  }
}
