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
		this.name = "Purchase";
		this.customer = customer;
	}
	
	public void run() {
		// Decrease customer count in store by one
		StoreState model = (StoreState) this.state;
		model.decreaseCustomerCount(customer);

		if (model.getQueue().length == 0) {
			model.emptyCheckout();
		}

		else {
			// Get first customer in queue
			eventQueue.addEvent(new PurchaseEvent(state, eventQueue, getFirstCustomerFromRegisterQueue(), 0.0));
		}

		// Save info about another customer has finished
		model.updatePurchaseCount();
		_updateTime(model);
		model.update();
	}

	private void _updateTime(StoreState model) {
		model.setTime(this.time);
	}
	
	public double getTime() {
		return time;
	}
	
	public String getName() {
		return name;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}