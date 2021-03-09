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
public class StartEvent extends Event {

	private ClosingEvent closingEvent; 
	private ArrivalEvent arrivalEvent;
	private double closeTime;
	
	public StartEvent(SimState state, EventQueue eventQueue) 
	{
		super(state, eventQueue);
		this.time = 0d;
		this.name = "Start";
		this.customer = null;
	}
	
	public void run() 
	{
		state.update(this);
		
		closingEvent = new ClosingEvent(this.state, eventQueue, closeTime);
		eventQueue.addEvent(closingEvent);
			      
		double arrivalTime = 0d;
		do 
		{
//			arrivalTime = arrivalTime + state.getArrivalTime().next();
			arrivalEvent = new ArrivalEvent(this.state, this.eventQueue, arrivalTime);
			eventQueue.addEvent(arrivalEvent);
		}while(closeTime > arrivalTime);
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
