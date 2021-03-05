package lab5.sim;

import java.util.Observable;

import lab5.store.StoreState;
/**
 * is the general state of the simulation
 * @author Pontus Eriksson Jirbratt
 *
 */
public class SimState extends Observable
{
	double currentTime;
	int numberOfEvents = 0;
	protected boolean runFlag;
	Object currentSim;
	
	/**
	 * Constructor set the time to zero and set the flag for the program to true
	 */
	public SimState()
	{
		currentTime = 0;
		runFlag = true;
	}
	
	public SimState(Object sim)
	{
		this.currentSim = sim;
		currentTime = 0;
		runFlag = true;
		
	}
	
	void setRunflag() 
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
	
	/**
	 * increments the time when events happen
	 */
	void incrementTime(int t) 
	{
		currentTime += t;
	}
	/**
	 * updates the observer
	 */
	public void update(Event currentEvent) 
	{
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
	public double getcurrentTime()
	{
		return currentTime;
	}
	
	public StoreState getCurrentSim()
	{
		return (StoreState) currentSim;
	}
	
}
