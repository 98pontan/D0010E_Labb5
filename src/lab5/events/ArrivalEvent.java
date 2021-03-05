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
	
	public ArrivalEvent(SimState state, EventQueue eventQueue, double time) 
	{
		super(state, eventQueue);
		this.time = time;
		this.name = "Arrival";
//		this.customer = this.state.model.createcustomer();
	}
	
	public void run() 
	{
		state.update(this);
//		state.getCurrentSim().addCustomer();
//		
		if(customer.getState() == CustomerState.IN_STORE)
		{
//	    	double gatherTime = this.time + state.getGatherTime().next();
//	    	gatherEvent = new GatherEvent(this.state, this.eventQueue, customer, gatherTime);
	    	eventQueue.addEvent(gatherEvent);
	    }
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
