package lab5.sim;

public class Simulator {
    SimState model;
    SimView view;
    EventQueue queue;

    public Simulator(SimState model, SimView view, EventQueue queue) {
        this.model = model;
        this.view = view;
        this.queue = queue;
    }

    public void run() {
        while (model.isRunning()) {
            queue.getNext().execute();
        }
    }
}
