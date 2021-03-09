package lab5.view;
import lab5.sim.EventQueue;
import lab5.sim.SimState;
import lab5.store.*;
import lab5.events.*;

public class StoreView extends SimView{
  private SimState simState;
  private StoreState storeState;
  
  public class StoreView(SimState simState, StoreState storeState){
    super(simState,storeState);
    this.simState = simState;
    this.storeState = storeState;
  }
  
  private void printStart(){
    System.out.println("PARAMETRAR");
    System.out.println("==========");
    System.out.println("Antal kassor, N..........: ");
    System.out.println("Max som ryms, M..........: ");
    System.out.println("Ankomsthastighet, lambda.: ");
    System.out.println("Plocktider, [P_min..Pmax]: ");
    System.out.println("Betaltider, [K_min..Kmax]: ");
    System.out.println("Frö, f...................: ");
    System.out.println("");
  }
  
  private void printEvents(){
    System.out.println("");
  }
  
  private void printEnd(){
    System.out.println("");
    System.out.println("RESLUTAT");
    System.out.println("========");
    System.out.println(""); //"Av " + vad ska skrivas här??
    System.out.println("1) Av " + StoreState.getCustomers() + " kunder handlade " +  + " medan " + + " missades."); 
    System.out.println("");
    System.out.println("2) Total tid " + + " kassor varit lediga: " + + " te.");
    System.out.println("   Genomsnittlig ledig kassatid: " + + " te (dvs " + + "% av tiden från öppning tills sista kunden betalat).");
    System.out.println("");
    System.out.println("3) Total tid " + + " kunder tvingats köa: " + + " te.");
    System.out.println("   Genomsnittlig kötid: " + + " te.");
  }
  
  public void update(Observable o, Object arg){
    
  }
  
}
