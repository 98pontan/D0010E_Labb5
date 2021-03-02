package lab5.main;

import lab5.events.StartEvent;
import lab5.events.StopEvent;
import lab5.sim.EventQueue;
import lab5.sim.SimState;
import lab5.sim.SimView;
import lab5.sim.Simulator;
import lab5.store.StoreState;
import lab5.view.StoreView;

public class RunSim {
    public static void main(String[] args) {
        final int REGISTERS         = 3;
        final int MAX_CUSTOMERS     = 30;
        // How many customers that arrive per time unit
        final int CUSTOMER_INTERVAL = 4;
        final int SIM_TIME          = 10;
        final int SEED              = 9999;

        SimState model = new StoreState();
        SimView view = new StoreView(/*model*/);
        EventQueue queue = new EventQueue();
        queue.add(new StartEvent(/*SEED, REGISTERS, MAX_CUSTOMERS, CUSTOMER_INTERVAL*/));
        queue.add(new StopEvent(/*SIM_TIME*/));

        Simulator sim = new Simulator(model, view, queue);
        sim.run();
    }
}
