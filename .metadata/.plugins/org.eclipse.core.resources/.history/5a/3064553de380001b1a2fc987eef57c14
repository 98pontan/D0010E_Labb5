package lab5.sim;

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
        // TODO: When done, remember to print out final information
        // Maybe through SimView class? By creating endPrint function?
    }
}
