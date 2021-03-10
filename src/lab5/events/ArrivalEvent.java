package lab5.events;
import lab5.sim.*;
import lab5.store.*;

/**
 * Description
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt, 
 * @author Jesper Johansson Oskarsson, 
 * @author Markus Blomqvist
 *
 */
public class ArrivalEvent extends Event {
	
	private GatherEvent gatherEvent;
	private ArrivalEvent arrivalEvent;

	public ArrivalEvent(SimState state, EventQueue eventQueue, double time) 
	{
		super(state, eventQueue);
		this.time = time;
		this.name = "Ankomst";

		StoreState store = (StoreState) state;
		// Skapa alltid en kund, men läggs bara till inne i butiken nedan
		this.customer = store.getCustomerFactory().createCustomer();
	}

	/**
	 * execution of arrival event
	 * if the store is closed, the customer will be turned away and missed customers will increase by one.
	 * else an arrival event is created
	 * if the store is open and not full, a new customer will be created
	 * else increase missed customers by one
	 */
	public void run() 
	{
		state.setTime(time);
		state.update(this);
		StoreState store = (StoreState) this.state;

		// TODO: Make it pretty? Switch maybe?
		if (!store.isOpen()) {
			store.turnedAwayCustomer();
		}

		else {
			double arrivalTime = store.getTimeFactory().generateArrivalTime();
			arrivalEvent = new ArrivalEvent(store, this.eventQueue, arrivalTime);
			eventQueue.addEvent(arrivalEvent);
		}

		if (store.isOpen() && !store.isFull()) {
			store.getCustomerList().add(customer);
			double gatherTime = store.getTimeFactory().generateGatherTime();
	    	gatherEvent = new GatherEvent(store, this.eventQueue, customer, gatherTime);
			eventQueue.addEvent(gatherEvent);
		}

		else {
			store.missedCustomers();
		}

		store.createCheckoutFreeTime(time);
	}
}
