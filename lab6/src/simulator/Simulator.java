package simulator;

public class Simulator {
    private EventQueue eventQueue;
    private SimState simState;

    public Simulator(EventQueue eventQueue, SimState simState) {
        this.eventQueue = eventQueue;
        this.simState = simState;
    }

    public void run() {
        while (simState.isOn()) {
             eventQueue.getEvent().Run(simState);
        }
    }
}
