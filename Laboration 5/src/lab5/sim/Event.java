package lab5.sim;

import lab5.store.*;

/**
 * Abstract template for all events. Holds time, event name and customer.
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
abstract public class Event {

	protected SimState state;
	protected EventQueue eventQueue;
	protected Customer customer;

	protected String name;
	protected double time;

	/**
	 * Sets the event SimState and EventQueue.
	 *
	 * @param state
	 * @param eventQueue
	 */
	public Event(SimState state, EventQueue eventQueue) {
		this.state = state;
		this.eventQueue = eventQueue;
	}

	/**
	 * Responsible for executing the main event code.
	 */
	abstract public void run();

	/**
	 *
	 * @return The event time
	 */
	public double getTime() {
		return this.time;
	};

	/**
	 *
	 * @return The event name
	 */
	public String getName() {
		return this.name;
	};

	/**
	 *
	 * @return The customer object
	 */
	public Customer getCustomer() {
		return this.customer;
	};
}
