package lab5.store;

import lab5.random.*;
import lab5.sim.SimState;

public class Time {
    private UniformRandomStream uniRegisterRnd;
    private UniformRandomStream uniGatherRnd;
    private ExponentialRandomStream expArrivalRnd;
    private StoreState store;

    public Time(
            StoreState store,
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
        this.store      = store;
    }

    public double generateRegisterTime() {
        return store.getcurrentTime() + uniRegisterRnd.next();
    }

    public double generateGatherTime() {
        return store.getcurrentTime() + uniGatherRnd.next();
    }

    public double generateArrivalTime() {
        return store.getcurrentTime() + expArrivalRnd.next();
    }
}
