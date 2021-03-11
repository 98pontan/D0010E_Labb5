package lab5.events;

import lab5.sim.*;
import lab5.store.*;

/**
 * Represents the opening of the store
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
public class StartEvent extends Event {
	/**
	 * Initializes parameters, since it's a start event time is 0 and customer is
	 * null
	 *
	 * @param state      the SimState model
	 * @param eventQueue the EventQueue
	 */
	public StartEvent(SimState state, EventQueue eventQueue) {
		super(state, eventQueue);
		this.time = 0d;
		this.name = "Start";
		this.customer = null;
	}

	/**
	 * Opens the store and creates the first arrival event
	 */
	public void run() {
		StoreState store = (StoreState) this.state;
		store.update(this);
		store.toggleIsOpen();

		double arrivalTime = store.getTimeFactory().generateArrivalTime();
		ArrivalEvent arrivalEvent = new ArrivalEvent(this.state, this.eventQueue, arrivalTime);
		eventQueue.addEvent(arrivalEvent);
	}
}
