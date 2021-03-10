package lab5.events;
import lab5.sim.*;

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
		this.time = 999;
		this.name = "Stop";
		this.customer = null;
	}

	/**
	 * Stops the simulation
	 */
	public void run() 
	{
		state.update(this);
		state.setRunFlagFalse();
	}
}
