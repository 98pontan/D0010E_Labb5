package lab5.sim;

import java.util.Observable;

/**
 * is the general state of the simulation
 * @author Pontus Eriksson Jirbratt
 *
 */
public class SimState extends Observable
{
	double currentTime;
	int numberOfEvents = 0;
	boolean runFlag;
	Event lastEvent;
	Object currentSim;
	
	/**
	 * Constructor set the time to zero and set the flag for the program to true
	 */
	public SimState(Object sim)
	{
		this.currentSim = sim;
		currentTime = 0;
		runFlag = true;
		
	}

    public SimState() {

    }

	public Object getCurrentSim() {
		return currentSim;
	}

	public void setRunflagFalse()
	{
		runFlag = false;
	}
	
	/**
	 * Increments number of events
	 */
	void newEvent() 
	{
		numberOfEvents++;
	}
	
	public void setTime(double time) {
		currentTime += time;
	}

	public Event getLastEvent() {
		return lastEvent;
	}

	/**
	 * updates the observer
	 */
	public void update(Event e)
	{
		lastEvent = e;
		newEvent();
		setChanged();
		notifyObservers();
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
}
