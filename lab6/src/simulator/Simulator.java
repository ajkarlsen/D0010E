package simulator;

import carwash.CarWashView;
import carwash.CarWashState;

public class Simulator {
    private EventQueue eventQueue;
    private SimState simState;
    private CarWashView carWashView;

    public Simulator(EventQueue eventQueue, SimState simState, CarWashView carWashView) {
        this.eventQueue = eventQueue;
        this.simState = simState;
        this.carWashView = carWashView;
    }

    public void run() {
        carWashView.firstPrint();

        while (simState.isOn()) {
            Event event = eventQueue.getEvent();
            if (event == null) {
                System.out.println("No more events in queue. Stopping simulation.");
                break;
            }
            event.Run(simState);
        }
    }
}
