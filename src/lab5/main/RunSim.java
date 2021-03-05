package lab5.main;

import lab5.events.StartEvent;
import lab5.events.ClosingEvent;
import lab5.events.StopEvent;
import lab5.sim.*;
import lab5.store.StoreState;
import lab5.view.StoreView;

public class RunSim {
    public static void main(String[] args) {
        final int SEED              = 1234;
        final int REGISTERS         = 2;
        final int MAX_CUSTOMERS     = 5;
        // Simulation run time in time units
        final double SIM_TIME       = 10.0;
        // How many customers that arrive per time unit
        final double ARRIVAL_SPEED  = 1.0;
        // Lower and upper limits in time generation for
        // corresponding events
        final double lowerGather    = 0.5, upperGather      = 1.0;
        final double lowerRegister  = 2.0, upperRegister    = 3.0;

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
        queue.addEvent(new ClosingEvent(model, queue, SIM_TIME));
        queue.addEvent(new StopEvent(model, queue));

        Simulator sim = new Simulator(model, queue);
        sim.run();
    }
}