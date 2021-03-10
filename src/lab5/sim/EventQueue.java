package lab5.sim;

import java.util.ArrayList;

/**
 * Creates an ArrayList of events
 * Add and removes events
 * Updates the list with the class SortedSequence
 *
 * @author Pontus Eriksson Jirbratt
 */

public class EventQueue
{

   ArrayList<Event> eventQueue;

   public EventQueue() {
      eventQueue = new ArrayList<>();
   }
   /**
    * Constructor that takes an ArrayList of events and set the current eventQueue to it.
    *
    * @param eveQueue
    */
   public EventQueue(ArrayList<Event> eveQueue)
   {
      eventQueue = eveQueue;
   }

   

   /**
    * Returns the eventQueue. 
    * @return eventQueue
    */
   public ArrayList<Event> getEventQueue()
   {
      return eventQueue;
   }
   
   /**
    * Adds a new event 
    * Creates a SortedSequence object to sort it
    * Sets the current eventQueue to the sorted eventQueue
    * @param event
    */
   public void addEvent(Event event)
   {
      eventQueue.add(0, event);
      SortedSequence ss = new SortedSequence();
      eventQueue = ss.sortList(eventQueue);
   }
   
   /**
    * Fetches the event at the first position 
    * stores it locally
    * removes it from the list
    * @return the event in the first position of eventQueue
    */
   Event popNextEvent()
   {
      final int NEXTEVENT = 0;
      Event event;

      event = eventQueue.get(NEXTEVENT);
      eventQueue.remove(NEXTEVENT);

      return event;
   }
}
