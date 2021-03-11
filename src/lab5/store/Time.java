package lab5.store;

import lab5.random.*;

/**
 * Generates times for use in events
 *
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 */
public class Time {
    private UniformRandomStream uniRegisterRnd;
    private UniformRandomStream uniGatherRnd;
    private ExponentialRandomStream expArrivalRnd;
    private StoreState state;

    /**
     * Creates objects for time generation
     *
     * @param state the StoreState model
     * @param SEED a seed value for the timeFactory
     * @param lowerGather the lower range for the time of gather events
     * @param upperGather the upper range for the time of gather events
     * @param lowerCheckout the lower range for the time of checkout queues
     * @param upperCheckout the upper range for the time of checkout queues
     * @param lambda the arrival speed
     */
    public Time(
            StoreState state,
            long SEED,
            double lowerCheckout,
            double upperCheckout,
            double lowerGather,
            double upperGather,
            double lambda
    ) {
        uniRegisterRnd  = new UniformRandomStream(lowerCheckout,upperCheckout, SEED);
        uniGatherRnd    = new UniformRandomStream(lowerGather,upperGather, SEED);
        expArrivalRnd   = new ExponentialRandomStream(lambda, SEED);
        this.state      = state;
    }

    /**
     *
     * @return time for purchase events
     */
    public double generatePurchaseTime() {
        return state.getCurrentTime() + uniRegisterRnd.next();
    }

    /**
     *
     * @return time for gather events
     */
    public double generateGatherTime() {
        return state.getCurrentTime() + uniGatherRnd.next();
    }

    /**
     *
     * @return time for arrival events
     */
    public double generateArrivalTime() {
        return state.getCurrentTime() + expArrivalRnd.next();
    }
}
