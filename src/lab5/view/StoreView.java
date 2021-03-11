package lab5.view;
import lab5.sim.Event;
import lab5.sim.SimView;
import lab5.store.*;
import lab5.events.*;

import java.util.Observable;

/**
 * This class prints out the data for the simulation of the store.
 * It prints out the start followed by the events that is called and then the end.
 *
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 */

public class StoreView extends SimView {
  private StoreState storeState;
  
  /**
   * Sets the state and calls constructor in SimView
   *
   * @param storeState model to observe
   */
  public StoreView(StoreState storeState){
    super(storeState);
    this.storeState = storeState;
  }
  
  /**
   * Prints out the initial parameters.
   */
  private void printStart(){
    System.out.println("PARAMETRAR");
    System.out.println("==========");
    System.out.println("Antal kassor, N..........: " + storeState.getCHECKOUTS());
    System.out.println("Max som ryms, M..........: " + storeState.getMaxCustomers());
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
   * Prints out the event data.
   *
   * @param e the current event
   */
  private void printEvents(Event e) {
    String eventName = e.getName();

    // Get the customer ID, if null set to "---"
    String customerID = String.valueOf(e.getCustomer());
    if (customerID.equals("null")) {
      customerID = "---";
    }
    
    String checkOpen = storeState.isOpen() ? "Ö" + "\t" : "S" + "\t";
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
   *
   * @param e the current event
   */
  private void printEnd(Event e) {
    double checkoutFreeTime = storeState.getCheckoutFreeTime();
    double totQueueTime = storeState.getTotQueueTime();
    int availableCheckouts = storeState.getAvailableCheckouts();
    int totalInQueue = storeState.getCheckoutQueue().getTotalQueuers();


    System.out.println(timeFormat(storeState.getCurrentTime()) + "\tStop");
    System.out.println("");
    System.out.println("RESUlTAT");
    System.out.println("========");
    System.out.println("");
    System.out.println("1) Av " + storeState.getTotCustomers() + " kunder handlade " +
            storeState.getPurchases() + " medan " + storeState.getMissedCustomers() +
            " missades.");
    System.out.println("");
    System.out.println("2) Total tid " + storeState.getCHECKOUTS() +
            " kassor varit lediga: " + timeFormat(checkoutFreeTime)  + " te.");
    System.out.println("   Genomsnittlig ledig kassatid: " +
            timeFormat(checkoutFreeTime/availableCheckouts) + " te (dvs " +
            timeFormat((checkoutFreeTime/availableCheckouts / storeState.getTimeAtCheckout())*100) +
            "% av tiden från öppning tills sista kunden betalat).");
    System.out.println("");
    System.out.println("3) Total tid " + totalInQueue + " kunder tvingats köa: " +
            timeFormat(totQueueTime) + " te.");
    System.out.println("   Genomsnittlig kötid: " +
            timeFormat(totQueueTime / totalInQueue) + " te.");
  }

  /**
   * Makes sure that the time has the correct format
   * to print out in the simulation with 2 decimals.
   *
   * @return a String of the time used in the print methods.
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
