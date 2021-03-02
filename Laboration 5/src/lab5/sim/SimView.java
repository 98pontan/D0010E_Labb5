package lab5.sim;
import java.util.Observable;
import java.util.Observer;
import lab5.SimState;
import lab5.SimState.StoreState;


public abstract class SimView implements Observer{
  private State simState;
  private State storeState;
  
  public SimView(State simState, State storeState){
    simState.addObserver(this);
    storeState.addObserver(this);
  }
  
  abstract public void update(Observable o, Object arg);
}
