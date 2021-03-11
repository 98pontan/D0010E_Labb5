package lab5.events;

import lab5.sim.*;
import lab5.store.*;

/**
 * Event representing closing the store for new arriving customers
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
public class ClosingEvent extends Event {
	/**
	 * Initializes parameters.
	 *
	 * @param state      the SimState model
	 * @param eventQueue the EventQueue
	 * @param time       the execution time of the event
	 */
	public ClosingEvent(SimState state, EventQueue eventQueue, double time) {
		super(state, eventQueue);
		this.time = time;
		this.name = "Stäng";
		this.customer = null;
	}

	/**
	 * Closes the store, no customers can enter the store.
	 */
	public void run() {
		StoreState store = (StoreState) this.state;
		store.update(this);
		store.toggleIsOpen();
	}
}
