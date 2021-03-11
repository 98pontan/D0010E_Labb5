package lab5.main;

import lab5.events.StartEvent;
import lab5.events.ClosingEvent;
import lab5.events.StopEvent;
import lab5.sim.Simulator;
import lab5.sim.EventQueue;
import lab5.store.StoreState;
import lab5.view.StoreView;

/**
 * Initializes the simulation with values and creates the necessary objects.
 *
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */

public class RunSim {
	public static void main(String[] args) {
		long SEED;
		int CHECKOUTS;
		int MAX_CUSTOMERS;
		// Simulation run time in time units
		double SIM_TIME;
		// How many customers that arrive per time unit, also called lambda
		double ARRIVAL_SPEED;
		// Lower and upper limits in time generation for
		// corresponding events
		double lowerGather;
		double lowerCheckout;
		double upperGather;
		double upperCheckout;

		if (true) {
			SEED = 1234;
			CHECKOUTS = 2;
			MAX_CUSTOMERS = 5;
			SIM_TIME = 10.0;
			ARRIVAL_SPEED = 1.0;
			lowerGather = 0.5;
			upperGather = 1.0;
			lowerCheckout = 2.0;
			upperCheckout = 3.0;
		}

		else {
			SEED = 13;
			CHECKOUTS = 2;
			MAX_CUSTOMERS = 7;
			SIM_TIME = 8.0;
			ARRIVAL_SPEED = 3.0;
			lowerGather = 0.6;
			upperGather = 0.9;
			lowerCheckout = 0.35;
			upperCheckout = 0.6;
		}

		StoreState model = new StoreState(SEED, CHECKOUTS, MAX_CUSTOMERS, ARRIVAL_SPEED, lowerGather, upperGather,
				lowerCheckout, upperCheckout);
		StoreView view = new StoreView(model);
		EventQueue queue = new EventQueue();
		queue.addEvent(new StopEvent(model, queue));
		queue.addEvent(new ClosingEvent(model, queue, SIM_TIME));
		queue.addEvent(new StartEvent(model, queue));

		Simulator sim = new Simulator(model, queue);
		sim.run();
	}
}