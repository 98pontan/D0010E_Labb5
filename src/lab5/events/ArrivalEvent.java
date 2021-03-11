package lab5.events;

import lab5.sim.*;
import lab5.store.*;

/**
 * Represents a new customer arriving to the store
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
public class ArrivalEvent extends Event {
	/**
	 * Initializes parameters and gets a StoreState, also creates a new customer
	 *
	 * @param state      the SimState model
	 * @param eventQueue the EventQueue
	 * @param time       the execution time of the event
	 */
	public ArrivalEvent(SimState state, EventQueue eventQueue, double time) {
		super(state, eventQueue);
		this.time = time;
		this.name = "Ankomst";

		StoreState store = (StoreState) state;
		this.customer = store.getCustomerFactory().createCustomer();
	}

	/**
	 * execution of arrival event if the store is closed, the customer will be
	 * turned away and missed customers will increase by one. else an arrival event
	 * is created if the store is open and not full, a new customer will be added to
	 * the store else increase missed customers by one
	 */
	public void run() {
		StoreState store = (StoreState) this.state;
		store.update(this);

		if (store.isOpen()) {
			double arrivalTime = store.getTimeFactory().generateArrivalTime();
			ArrivalEvent arrivalEvent = new ArrivalEvent(store, this.eventQueue, arrivalTime);
			eventQueue.addEvent(arrivalEvent);
		}

		if (store.isOpen() && !store.isFull()) {
			store.incrementCustomers();
			store.getCustomerList().add(customer);
			double gatherTime = store.getTimeFactory().generateGatherTime();
			GatherEvent gatherEvent = new GatherEvent(store, this.eventQueue, customer, gatherTime);
			eventQueue.addEvent(gatherEvent);
		}

		else if (store.isOpen()) {
			store.missedCustomers();
			store.incrementCustomers();
		}
	}
}
