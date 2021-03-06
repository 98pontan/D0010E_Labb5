package lab5.main;

import java.util.ArrayList;
import java.util.Random;
import lab5.events.StartEvent;
import lab5.K;
import lab5.events.ClosingEvent;
import lab5.events.StopEvent;
import lab5.sim.*;
import lab5.store.Customer;
import lab5.store.StoreState;

/**
 * This class is used to optimize the operations of a simulated environment. It
 * runs simulations to find the optimal amount of checkouts while the other
 * parameters is set.
 * 
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 */
public class Optimize {

	/**
	 * Prints the results of optimizeSim and optimizeRandSeed
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Optimize opt = new Optimize();
		long SEED = K.SEED;

		System.out.println("Minsta antal kassor som ger minimalt antal missade kunder (" + opt.optimizeSim(SEED).get(0)
				+ "): " + opt.optimizeSim(SEED).get(1));
		System.out.println(opt.optimizedRandSeed(SEED));
	}

	/**
	 * 
	 * Creates a StoreState and runs the sim
	 * 
	 * @param SEED          a seed value for the timeFactory
	 * @param CHECKOUTS     The number of checkouts in the store
	 * @param MAX_CUSTOMERS The maximum number of customers that can be inside the
	 *                      store
	 * @param lowerGather   the lower range for the time of gather events
	 * @param upperGather   the upper range for the time of gather events
	 * @param ARRIVAL_SPEED a constant for the timeFactory
	 * @param lowerCheckout the lower range for the time of checkout queues
	 * @param upperCheckout the upper range for the time of checkout queues
	 * @param SIM_TIME      when the store will close
	 * @return the StoreState model
	 */
	public StoreState createSim(long SEED, int CHECKOUTS, int MAX_CUSTOMERS, double lowerGather, double upperGather,
			double ARRIVAL_SPEED, double lowerCheckout, double upperCheckout, double SIM_TIME) {

		StoreState model = new StoreState(SEED, CHECKOUTS, MAX_CUSTOMERS, ARRIVAL_SPEED, lowerGather, upperGather,
				lowerCheckout, upperCheckout);

		EventQueue queue = new EventQueue();
		queue.addEvent(new StopEvent(model, queue));
		queue.addEvent(new ClosingEvent(model, queue, SIM_TIME));
		queue.addEvent(new StartEvent(model, queue));

		Simulator sim = new Simulator(model, queue);
		sim.run();

		return model;
	}

	/**
	 * Optimizes the number of checkouts and the minimun missed customers
	 * 
	 * @param SEED a seed
	 * @return the optimized values
	 */
	public ArrayList<Integer> optimizeSim(long SEED) {
		// The first method's parameters.
		int MAX_CUSTOMERS = K.M;
		double SIM_TIME = K.END_TIME;
		double ARRIVAL_SPEED = K.L;
		double lowerGather = K.LOW_COLLECTION_TIME;
		double upperGather = K.HIGH_COLLECTION_TIME;
		double lowerRegister = K.LOW_PAYMENT_TIME;
		double upperRegister = K.HIGH_PAYMENT_TIME;

		// The minimal amount of checkouts can not be bigger than MAX_CUSTOMERS.
		int checkouts = MAX_CUSTOMERS;
		StoreState initStore = createSim(SEED, checkouts, MAX_CUSTOMERS, lowerGather, upperGather, ARRIVAL_SPEED,
				lowerRegister, upperRegister, SIM_TIME);

		int optimizedCheckouts = 0;
		int optimizedCustomers = 0;
		ArrayList<Integer> values = new ArrayList<Integer>();

		while (checkouts >= 1) {
			StoreState newStore = createSim(SEED, checkouts, MAX_CUSTOMERS, lowerGather, upperGather, ARRIVAL_SPEED,
					lowerRegister, upperRegister, SIM_TIME);

			if (newStore.getMissedCustomers() <= initStore.getMissedCustomers()) {
				optimizedCheckouts = newStore.getCHECKOUTS();
				optimizedCustomers = newStore.getMissedCustomers();
			}

			checkouts--;
		}
		values.add(0, optimizedCustomers);
		values.add(1, optimizedCheckouts);
		return values;
	}

	/**
	 * Tests the optimal number of checkouts
	 * 
	 * @param SEED a seed
	 * @return the optimal number of checkouts
	 */
	public int optimizedRandSeed(long SEED) {
		// Sets a random seed number.
		Random rand = new Random(SEED);
		int maxMinCheckouts = 0;
		int counter = 0;

		// Runs 100 times if the maximum of the minimum number of checkouts has not
		// changed.
		while (counter < 100) {

			// Creates a new amount of checkouts by sending in a new random SEED into the
			// second method.
			int newCheckouts = optimizeSim(rand.nextLong()).get(1);

			// If true, the counter resets. If false then the counter counts up by 1.
			if (maxMinCheckouts < newCheckouts) {
				maxMinCheckouts = newCheckouts;
				counter = 0;
			} else {
				counter++;
			}
		}

		return maxMinCheckouts;
	}
}
