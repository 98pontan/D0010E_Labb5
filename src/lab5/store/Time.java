package lab5.store;

import lab5.random.*;
import lab5.sim.SimState;

public class Time {
    private UniformRandomStream uniRegisterRnd;
    private UniformRandomStream uniGatherRnd;
    private ExponentialRandomStream expArrivalRnd;

    public Time(
            long SEED,
            double lowerRegister,
            double upperRegister,
            double lowerGather,
            double upperGather,
            double lambda
    ) {
        uniRegisterRnd  = new UniformRandomStream(lowerRegister,upperRegister, SEED);
        uniGatherRnd    = new UniformRandomStream(lowerGather,upperGather, SEED);
        expArrivalRnd   = new ExponentialRandomStream(lambda, SEED);
    }

    public double generateRegisterTime() {
        return SimState.getCurrentTime() + uniRegisterRnd.next();
    }

    public double generateGatherTime() {
        return SimState.getCurrentTime() + uniGatherRnd.next();
    }

    public double generateArrivalTime() {
        return SimState.getCurrentTime() + expArrivalRnd.next();
    }
}
