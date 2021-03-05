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
	abstract public double getTime();
	abstract public String getName();
	abstract public Customer getCustomer();
	
	public Event(SimState state, EventQueue eventQueue)
	{
		this.state = state;
		this.eventQueue = eventQueue;
	}
	
}
