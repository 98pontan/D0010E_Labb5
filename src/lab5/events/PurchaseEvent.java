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
		this.name = "Pay";
		this.customer = customer;
	}
	
	public void run() {
		state.setTime(time);
		// Decrease customer count in store by one
		StoreState model = (StoreState) this.state;
		// Make sure it's the right element being removed
		model.getCustomerList().remove(customer);

		if (model.getCheckoutQueue().isEmpty()) {
			model.emptyCheckout();

		}

		else {
			double queueTime;
			eventQueue.addEvent(new PurchaseEvent(
					model,
					eventQueue,
					model.getCheckoutQueue().getFirst(),
					model.getTimeFactory().generateRegisterTime()
			));
			queueTime = model.getCheckoutQueue().getFirst().getQueueTime(time);
			model.setTotQueueTime(queueTime);
			model.getCheckoutQueue().removeFirst();
		}

		// Save info about another customer has finished
		model.updatePurchaseCount();
		state.update(this);
	}
}