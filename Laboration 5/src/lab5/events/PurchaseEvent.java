package lab5.events;

import lab5.store.StoreState;
import lab5.store.Customer;
import lab5.sim.Event;
import lab5.sim.EventQueue;

/**
 * Represents when a customer has finished paying for their
 * goods and are leaving the store
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt, 
 * @author Jesper Johansson Oskarsson, 
 * @author Markus Blomqvist
 *
 */
public class PurchaseEvent extends Event {
	/**
	 * Initializes parameters
	 *
	 * @param state the SimState model
	 * @param eventQueue the EventQueue
	 * @param customer the customer object
	 * @param time the execution time of the event
	 */
	public PurchaseEvent(StoreState state, EventQueue eventQueue, Customer customer, double time) {
		super(state, eventQueue);
		this.time = time;
		this.name = "Betal";
		this.customer = customer;
	}

	/**
	 * execution of the Purchase event
	 * removes customer from store
	 * empties one checkout if no queue,
	 * else bring one Customer from queue to checkout
	 * updates data of successful purchases
	 */
	public void run() {
		StoreState store = (StoreState) this.state;
		store.update(this);
		store.getCustomerList().remove(customer);

		if (store.getCheckoutQueue().isEmpty()) {
			store.emptyCheckout();
		}

		else {
			eventQueue.addEvent(new PurchaseEvent(
					store,
					eventQueue,
					store.getCheckoutQueue().getFirst(),
					store.getTimeFactory().generatePurchaseTime()
			));

			store.getCheckoutQueue().removeFirst();
		}

		store.updatePurchaseCount();
	}
}