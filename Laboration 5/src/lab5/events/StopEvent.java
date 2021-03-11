package lab5.events;

import lab5.sim.*;

/**
 * Represents the end of the simulation
 * 
 * @author Lucas Pettersson,
 * @author Pontus Eriksson Jirbratt,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
public class StopEvent extends Event {
	/**
	 * Initializes parameters, since it's a stop event time is irrelevant and
	 * customer is null
	 *
	 * @param state      the SimState model
	 * @param eventQueue the EventQueue
	 */
	public StopEvent(SimState state, EventQueue eventQueue) {
		super(state, eventQueue);
		this.time = 999;
		this.name = "Stop";
		this.customer = null;
	}

	/**
	 * Stops the simulation
	 */
	public void run() {
		state.update(this);
		state.setRunFlagFalse();
	}
}
