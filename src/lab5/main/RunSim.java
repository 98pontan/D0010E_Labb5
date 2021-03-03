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
        final int SEED              = 9999;
        final int REGISTERS         = 3;
        final int MAX_CUSTOMERS     = 30;
        // Simulation run time in time units
        final int SIM_TIME          = 10;
        // How many customers that arrive per time unit
        final double ARRIVAL_SPEED  = 4;
        // Lower and upper limits in time generation for
        // corresponding events
        final double lowerGather    = 1, upperGather = 2;
        final double lowerRegister  = 1, upperRegister = 2;

        SimState model = new StoreState();
        SimView view = new StoreView(/*model*/);
        EventQueue queue = new EventQueue();
        queue.add(new StartEvent(/*
                SEED,
                REGISTERS,
                MAX_CUSTOMERS,
                ARRIVAL_SPEED,
                lowerGather, upperGather,
                lowerRegister, upperRegister
        */));
        queue.add(new StopEvent(/*SIM_TIME*/));

        Simulator sim = new Simulator(model, view, queue);
        sim.run();
    }
}
