package lab5.main;

import lab5.events.StartEvent;
import lab5.sim.*;
import lab5.store.StoreState;
import lab5.view.StoreView;

public class RunSim {
    public static void main(String[] args) {
        final int SEED              = 9999;
        final int REGISTERS         = 3;
        final int MAX_CUSTOMERS     = 30;
        // Simulation run time in time units
        final double SIM_TIME       = 10.0;
        // How many customers that arrive per time unit
        final double ARRIVAL_SPEED  = 4.0;
        // Lower and upper limits in time generation for
        // corresponding events
        final double lowerGather    = 1.0, upperGather      = 2.0;
        final double lowerRegister  = 1.0, upperRegister    = 1.5;

        SimState model = new StoreState(
                SEED,
                REGISTERS,
                MAX_CUSTOMERS,
                ARRIVAL_SPEED,
                lowerGather, upperGather,
                lowerRegister, upperRegister
        );
        SimView view = new StoreView(model);
        // Should EventQueue really need a pre-made ArrayList?
        //ArrayList<Event> a = new ArrayList<>();
        //a.add(new StartEvent());
        //a.add(new StopEvent());
        EventQueue queue = new EventQueue();
        queue.addEvent(new StartEvent(model, queue));

        Simulator sim = new Simulator(model, queue);
        sim.run();
    }
}