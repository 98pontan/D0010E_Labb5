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
	
	public void run() {
		StoreState model = (StoreState) this.state;
		if (model.checkAvailableCheckout()) {
			model.closeCheckouts(1);
			eventQueue.addEvent(new PurchaseEvent(model, eventQueue, customer, 0.0));
		}

		else {
			model.addToQueue(customer);
		}

		_updateTime(model);
		model.update();
	}

	private void _updateTime(StoreState model) {
		model.setTime(this.time);
	}
	
	public double getTime()
	{
		return time;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Customer getCustomer()
	{
		return customer;
	}
}