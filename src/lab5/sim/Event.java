package lab5.sim;
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
 abstract public class Event {
	
	protected SimState state;
	protected EventQueue eventQueue;
	protected Customer customer;
	 
	protected String name;
	protected double time;
	
	abstract public void run();

	public double getTime() {
		return this.time;
	};

	public String getName() {
		return this.name;
	};

	public Customer getCustomer() {
		return this.customer;
	};

	protected void updateTime(SimState model) {
		model.setTime(this.time);
	}

	public Event(SimState state, EventQueue eventQueue)
	{
		this.state = state;
		this.eventQueue = eventQueue;
	}
	
}