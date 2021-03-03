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
	boolean runFlag;
	
	SimState(int openCheckouts, int customerLimit)
	{
		currentTime = 0;
		runFlag = true;
	}
	void update(double time) 
	{
		setChanged();
		notifyObservers();
	}
	
	boolean getSimRunning() 
	{
		
		return runFlag;
	}
	
	double getcurrentTime()
	{
		return currentTime;
	}
	
}
