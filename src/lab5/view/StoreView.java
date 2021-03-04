package lab5.view;
import lab5.sim.EventQueue;
import lab5.sim.SimState;
import lab5.store.*;
import lab5.events.*;

/**
 * This class prints out the data for the simulation of the store.
 * It prints out the start followed by the events that is called and then the end.
 * @author Markus Blomqvist
 */
// METODERNA MÅSTE KONTROLLERAS
public class StoreView extends SimView{
  private SimState simState;
  private StoreState storeState;
  
  /**
   * This is the constructor for this class.
   * It will use the states to get data.
   */
  public StoreView(SimState simState, StoreState storeState){
    super(simState,storeState);
    this.simState = simState;
    this.storeState = storeState;
  }
  
  /**
   * This method prints out the start.
   */
  private void printStart(){
    System.out.println("PARAMETRAR");
    System.out.println("==========");
    System.out.println("Antal kassor, N..........: ") + storeState.getcheckOuts();
    System.out.println("Max som ryms, M..........: " + storeState.getMaxCustomersToday());
    System.out.println("Ankomsthastighet, lambda.: ") + ;
    System.out.println("Plocktider, [P_min..Pmax]: ") + "[" + + ".." + + "]";
    System.out.println("Betaltider, [K_min..Kmax]: ") + "[" + + ".." + + "]";
    System.out.println("Frö, f...................: ") + ;
    System.out.println("");
    System.out.println("FÖRLOPP");
    System.out.println("=======");
    System.out.println("Tid\tHändelse\tKund\t?\tled\tledT\tI\t$\t:-(\tköat\tköT\tköar\t[Kassakö..]");
  }
  
  /**
   * This method prints out the events.
   */
  private void printEvents(){
    String formatEvent = String.valueOf(simState.getCurrentEvent().getName());
    if(formatEvent.length() < 4){
      formatEvent = formatEvent + " ";
    }
    
    String checkCustomerNull = String.valueOf(simState.getCurrentCustomer());
    if(checkCustomerNull.equals("null")){
      checkCustomerNull = " ";
    }
  
    System.out.println(
              timeFormat(simState.getCurrentTime()) + "\t" +
              formatEvent + "\t\t" +
              checkCustomerNull + "\t" +
              storeState.getIsOpen() + "\t" +
              storeState.getFreeRegisters() + "\t" +
              formatNumber(storeState.getRegisterFreeTime()) + "\t" +
              storeState.getCustomersInStore() + "\t" +
              storeState.getCoinMade() + "\t" +
              storeState.getCustomersTurnedAway() + "\t" +
              storeState.getTotalCustomersInQueue() + "\t" +
              timeFormat(storeState.getCustomerQueueTime()) + "\t" +
              storeState.getFIFOQueue().size() + "\t" +
              storeState.getFIFOQueue());
  }
  
  /**
   * This method prints out the end.
   */
  private void printEnd(){
    System.out.println("");
    System.out.println("RESLUTAT");
    System.out.println("========");
    System.out.println(""); // Totala antalet kunder, kunder som handlade, missade kunder. (kan vara fel i 1) nedan)
    System.out.println("1) Av " + storeState.getCustomers() + " kunder handlade " + storeState.getMaxCustomersToday() + " medan " + storeState.getMissedCustomers() + " missades."); 
    System.out.println("");
    System.out.println("2) Total tid " + + " kassor varit lediga: " + + " te.");
    System.out.println("   Genomsnittlig ledig kassatid: " + + " te (dvs " + + "% av tiden från öppning tills sista kunden betalat).");
    System.out.println("");
    System.out.println("3) Total tid " + + " kunder tvingats köa: " + + " te.");
    System.out.println("   Genomsnittlig kötid: " + + " te.");
  }

  /**
   * This method makes sure that the time has the correct format
   * to print out in the simulation with 2 decimals.
   * It returns a String of the time in the parameter.
   */
  private String timeFormat(double time){
    String printTime = String.valueOf(Math.round(time * 100.0) / 100.0);
    if(printTime.length() < 4){
      printTime = printTime + "0";
    }
    return printTime;
  }
  
  /**
   * This method updates the printing depending on what
   * the current event is.
   */
  public void update(Observable o, Object arg){
    if (simState.getCurrentEvent().getClass() == StartEvent.class){
      printStart();
      System.out.println(simState.getCurrentTime() + "\tStart");
    }
    else if (simState.getCurrentEvent().getClass() == StopEvent.class){
      System.out.println(timeFormat(simState.getCurrentTime()) + "\tStop");
      printEnd();
    }
    else{
      printEvents();
    }
  }
  
}
