package lab5.view;
import lab5.sim.Event;
import lab5.sim.SimView;
import lab5.store.*;
import lab5.events.*;

import java.util.Observable;

/**
 * This class prints out the data for the simulation of the store.
 * It prints out the start followed by the events that is called and then the end.
 * @author Markus Blomqvist
 */
// METODERNA MÅSTE KONTROLLERAS
public class StoreView extends SimView {
  private StoreState storeState;
  
  /**
   * This is the constructor for this class.
   * It will use the states to get data.
   */
  public StoreView(StoreState storeState){
    super(storeState);
    this.storeState = storeState;
  }
  
  /**
   * This method prints out the start.
   */
  private void printStart(){
    System.out.println("PARAMETRAR");
    System.out.println("==========");
    System.out.println("Antal kassor, N..........: " + storeState.getcheckOuts());
    System.out.println("Max som ryms, M..........: " + storeState.getMaxCustomersToday());
    System.out.println("Ankomsthastighet, lambda.: " + storeState.getArrivalSpeed());
    System.out.println("Plocktider, [P_min..Pmax]: " + "[" + storeState.getGatherLower() + ".." + storeState.getGatherUpper() + "]");
    System.out.println("Betaltider, [K_min..Kmax]: " + "[" + storeState.getCheckoutLower() + ".." + storeState.getCheckoutUpper() + "]");
    System.out.println("Frö, f...................: " + storeState.getSEED());
    System.out.println("");
    System.out.println("FÖRLOPP");
    System.out.println("=======");
    System.out.println("Tid\tHändelse\tKund\t?\tled\tledT\tI\t$\t:-(\tköat\tköT\tköar\t[Kassakö..]");
    System.out.println(storeState.getCurrentTime() + "\tStart");
  }
  
  /**
   * This method prints out the events.
   */
  private void printEvents(Event e) {
    String eventName = e.getName();
    if (eventName.length() < 4) { //magisk fyra (Avser nog tab)
      eventName = eventName + " ";
    }
    
    String customerID = String.valueOf(e.getCustomer());
    if (customerID.equals("null")) {
      customerID = "---";
    }
    
    String checkOpen;
    checkOpen = storeState.isOpen() ? "ö" + "\t" : "s" + "\t";
    
    System.out.println(
              timeFormat(e.getTime()) + "\t" +
              eventName + "\t\t" +
              customerID + "\t" +
              checkOpen +
              storeState.getAvailableCheckouts() + "\t" +
              timeFormat(storeState.getCheckoutFreeTime()) + "\t" +
              storeState.getCustomers() + "\t" +
              storeState.getPurchases() + "\t" +
              storeState.getMissedCustomers() + "\t" +
              storeState.getCheckoutQueue().getTotalQueuers()+ "\t" +
              timeFormat(storeState.getTotQueueTime()) + "\t" +
              storeState.getCheckoutQueue().size() + "\t" +
              storeState.getCheckoutQueue().toString());
  }
  
  /**
   * This method prints out the end.
   */
  private void printEnd(Event e) {
    System.out.println(timeFormat(storeState.getCurrentTime()) + "\tStop");
    System.out.println("");
    System.out.println("RESUlTAT");
    System.out.println("========");
    System.out.println(""); // Totala antalet kunder, kunder som handlade, missade kunder. (kan vara fel i 1) nedan)
    System.out.println("1) Av " + storeState.getTotCustomers() + " kunder handlade " + storeState.getPurchases() + " medan " + storeState.getMissedCustomers() + " missades.");
    System.out.println("");
    System.out.println("2) Total tid " + storeState.getcheckOuts() + " kassor varit lediga: " + timeFormat(storeState.getCheckoutFreeTime())  + " te.");
    System.out.println("   Genomsnittlig ledig kassatid: " + timeFormat(storeState.getCheckoutFreeTime()/storeState.getAvailableCheckouts())
            + " te (dvs " + timeFormat((storeState.getCheckoutFreeTime()/storeState.getAvailableCheckouts() / storeState.getTimeAtCheckoutFreeTime())*100)  + "% av tiden från öppning tills sista kunden betalat).");
    System.out.println("");
    System.out.println("3) Total tid " + storeState.getCheckoutQueue().getTotalQueuers() + " kunder tvingats köa: " + timeFormat(storeState.getTotQueueTime()) + " te.");
    System.out.println("   Genomsnittlig kötid: " + timeFormat(storeState.getTotQueueTime() / storeState.getCheckoutQueue().getTotalQueuers()) + " te.");
  }

  /**
   * This method makes sure that the time has the correct format
   * to print out in the simulation with 2 decimals.
   * It returns a String of the time used in the print methods.
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
    if (arg.getClass() == StartEvent.class) {
      printStart();
    }
    
    else if (arg.getClass() == StopEvent.class) {
      printEnd((Event) arg);
    }
    
    else{ 
      printEvents((Event) arg);
    }
  }
}
