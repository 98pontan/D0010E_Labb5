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
public class StopEvent extends Event {

	public StopEvent(SimState state, EventQueue eventQueue)
	{
		super(state, eventQueue);
		this.time = 0d;
		this.name = "Stop";
		this.customer = null;
	}
	
	public void run() 
	{
//		state.update(this);
//		state.setSimDisabled();
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
