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
public class PurchaseEvent extends Event {

	PurchaseEvent payEvent;
	private double payTime;
	
	public PurchaseEvent(SimState state, EventQueue eventQueue, Customer customer, double time)
	{
		super(state, eventQueue);
		this.time = time;
		this.name = "Purchase";
		this.customer = customer;
	}
	
	public void run() 
	{
		state.update(this);
//		
//		state.getCurrentSim().removeCustomer(customer);
//		state.getCurrentSim().unoccupieRegister();
//			      
//		if(!state.getCurrentSim().getFIFOQueue().isEmpty()) 
//		{
//			Customer customerFirstInLine = (Customer) state.getCurrentSim().getFIFOQueue().first();
//			
//			state.getCurrentSim().getFIFOQueue().removeFirst();
//			
//			payTime = this.time + state.getPayTime().next();
//			
//			payEvent = new PurchaseEvent(this.state, this.eventQueue, payTime, customerFirstInLine);
			eventQueue.addEvent(payEvent);
//			
//			state.getCurrentSim().occupieRegister();
//		}
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
