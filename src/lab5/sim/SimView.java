package lab5.sim;

import java.util.Observable;
import java.util.Observer;

/**
 * This class is the general view used for the simulator. It is an observer and
 * observes the state.
 * 
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 */
public abstract class SimView implements Observer {
	public SimView(SimState simState) {
		simState.addObserver(this);
	}

	abstract public void update(Observable o, Object arg);
}
