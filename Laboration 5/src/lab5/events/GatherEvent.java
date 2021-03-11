package lab5.events;

import lab5.store.StoreState;
import lab5.store.Customer;
import lab5.sim.Event;
import lab5.sim.EventQueue;

/**
 * Represents when a customer has finished collecting their items
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
public class GatherEvent extends Event {
	/**
	 * Initializes parameters
	 *
	 * @param state      the SimState model
	 * @param eventQueue the EventQueue
	 * @param customer   the customer object
	 * @param time       the execution time of the event
	 */
	public GatherEvent(StoreState state, EventQueue eventQueue, Customer customer, double time) {
		super(state, eventQueue);
		this.time = time;
		this.name = "Plock";
		this.customer = customer;
	}

	/**
	 * execution of gatherEvent if checkouts are available it will be occupied and a
	 * purchase event will be created. else the customer will be put into a queue.
	 */
	public void run() {
		StoreState store = (StoreState) this.state;
		store.update(this);

		if (store.checkAvailableCheckout()) {
			store.occupiedCheckout();
			eventQueue.addEvent(
					new PurchaseEvent(store, eventQueue, customer, store.getTimeFactory().generatePurchaseTime()));
		}

		else {
			store.getCheckoutQueue().add(customer);
		}
	}
}