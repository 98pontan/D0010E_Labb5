package lab5.sim;

import java.util.Observable;

/**
 * The general state of the simulation, keep tracks of time, events and if the simulation is still running
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */
public class SimState extends Observable {
	double currentTime;
	boolean runFlag;
	Event lastEvent;

	/**
	 * Constructor set the time to zero and set the flag for the program to true
	 */
	public SimState() {
		currentTime 	= 0;
		runFlag 		= true;
	}

	/**
	 * shuts down the simulation
	 */
	public void setRunFlagFalse() {
		runFlag = false;
	}

	/**
	 * Updates the observer, updates the currentTime to the events execution time.
	 * Also increments the event counter.
	 *
	 * @param e The event that called update
	 */
	public void update(Event e)
	{
		currentTime = e.getTime();

		setChanged();
		notifyObservers(e);
	}

	/**
	 * @return if the program is running 
	 */
	boolean getSimRunning() 
	{
		return runFlag;
	}
	
	/**
	 * @return the current time in the program
	 */
	public double getCurrentTime()
	{
		return currentTime;
	}

	/**
	 *
	 * @return the last called event
	 */
	public Event getLastEvent() {
		return lastEvent;
	}

	/**
	 *
	 * @param e the event to set as last event
	 */
	public void setLastEvent(Event e) {
		lastEvent = e;
	}
}
