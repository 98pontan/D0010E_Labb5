package lab5.events;

import lab5.store.StoreState;
import lab5.store.Customer;
import lab5.sim.Event;
import lab5.sim.EventQueue;

/**
 * Description
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt, 
 * @author Jesper Johansson Oskarsson, 
 * @author Markus Blomqvist
 *
 */
public class PurchaseEvent extends Event {
	public PurchaseEvent(StoreState state, EventQueue eventQueue, Customer customer, double executionTime) {
		super(state, eventQueue);
		this.time = executionTime;
		this.name = "Betal";
		this.customer = customer;
	}
	
	public void run() {
		StoreState store = (StoreState) this.state;
		store.update(this);
		// Decrease customer count in store by one
		// Make sure it's the right element being removed
		store.getCustomerList().remove(customer);

		if (store.getCheckoutQueue().isEmpty()) {
			store.emptyCheckout();

		}

		else {
			eventQueue.addEvent(new PurchaseEvent(
					store,
					eventQueue,
					store.getCheckoutQueue().getFirst(),
					store.getTimeFactory().generateRegisterTime()
			));
			//double queueTime = store.getCheckoutQueue().getFirst().getQueueTime(time);
			//store.setTotQueueTime(queueTime);
			store.getCheckoutQueue().removeFirst();
		}

		// Save info about another customer has finished
		store.updatePurchaseCount();
	}
}