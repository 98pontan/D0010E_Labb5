package lab5.sim;

/**
 * Handles running the simulator, triggers events from EventQueue.
 *
 * @author Pontus Eriksson Jirbratt,
 * @author Lucas Pettersson,
 * @author Jesper Johansson Oskarsson,
 * @author Markus Blomqvist
 *
 */

public class Simulator {
    SimState model;
    EventQueue queue;

    public Simulator(SimState model, EventQueue queue) {
        this.model = model;
        this.queue = queue;
    }

    public void run() {
        while (model.getSimRunning()) {
            queue.popNextEvent().run();
        }
    }
}
