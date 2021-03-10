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
		this.name = "St�ng";
		this.customer = null;
	}

	/**
	 * Closes the store, no customers can enter the store.
	 */
	public void run() 
	{
		state.setTime(time);
		state.update(this);
		StoreState store = (StoreState) this.state;
		store.toggleIsOpen();
	}
}