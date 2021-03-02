package lab5.sim;

public class Simulator {
    SimState model;
    SimView view;
    EventQueue queue;
    private boolean simRunning = true;

    public Simulator(SimState model, SimView view, EventQueue queue) {
        this.model = model;
        this.view = view;
        this.queue = queue;
    }

    public void run() {
        while (simRunning) {
            queue.getNext().execute();
        }
    }
}
