package lab5.sim;
import java.util.Observable;
import java.util.Observer;
import lab5.SimState;
import lab5.SimState.StoreState;

/**
 * This class is the general view used for the simulator.
 * It is an observer and observes the state.
 * @author Markus Blomqvist
 */
public abstract class SimView implements Observer{
  private SimState simState;
  private StoreState storeState;
  
  public SimView(SimState simState, StoreState storeState){
    simState.addObserver(this);
    storeState.addObserver(this);
  }
  
  abstract public void update(Observable o, Object arg);
}
