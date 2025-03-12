import carwash.*;
import simulator.*;

public class MainSim {
    public static void main(String[] args) {
        EventQueue eventQueue = new EventQueue();
        SimState simState = new SimState();
        CarWashState cws = new CarWashState(eventQueue);
        CarWashView view = new CarWashView(simState);
        Simulator sim = new Simulator(eventQueue, cws, view);


        eventQueue.addEvent(new Start(0.0));

        eventQueue.addEvent(new Stop(15.0));
        // Kör simuleringen
        sim.run();
    }
}