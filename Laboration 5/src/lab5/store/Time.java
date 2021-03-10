package lab5.store;

import lab5.random.*;

public class Time {
    private UniformRandomStream uniRegisterRnd;
    private UniformRandomStream uniGatherRnd;
    private ExponentialRandomStream expArrivalRnd;
    private StoreState state;

    public Time(
            StoreState state,
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
        this.state      = state;
    }

    public double generateRegisterTime() {
        return state.getCurrentTime() + uniRegisterRnd.next();
    }

    public double generateGatherTime() {
        return state.getCurrentTime() + uniGatherRnd.next();
    }

    public double generateArrivalTime() {
        return state.getCurrentTime() + expArrivalRnd.next();
    }
}