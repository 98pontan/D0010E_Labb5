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
public class ClosingEvent extends Event {

	public ClosingEvent(SimState state, EventQueue eventQueue, double time)
	{
		super(state, eventQueue);
		this.time = time;
		this.name = "Close";
		this.customer = null;
	}
	
	public void run() 
	{
		StoreState store = (StoreState) state.getCurrentSim();
		store.toggleIsOpen();
		store.update(this);
	}
}
