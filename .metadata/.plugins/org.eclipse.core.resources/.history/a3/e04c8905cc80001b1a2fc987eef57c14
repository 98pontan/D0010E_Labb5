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
public class GatherEvent extends Event {
	public GatherEvent(StoreState state, EventQueue eventQueue, Customer customer, double executionTime) {
		super(state, eventQueue);
		this.time = executionTime;
		this.name = "Gather";
		this.customer = customer;
	}

	/**
	 * execution of gatherEvent
	 * if checkouts are available it will be occupide and a purchase event will be created.
	 * else the customer will be put into a queue.
	 */
	public void run() {
		StoreState model = (StoreState) state.getCurrentSim();

		if (model.checkAvailableCheckout()) {
			model.createCheckoutFreeTime(time);
			model.occupideCheckout();
			eventQueue.addEvent(new PurchaseEvent(
					model,
					eventQueue,
					customer,
					model.getTimeFactory().generateRegisterTime())
			);
		}

		else {
			customer.setQueueTime(time);
			model.getCheckoutQueue().add(customer);
		}

		updateTime(model);
		state.update(this);
	}
}