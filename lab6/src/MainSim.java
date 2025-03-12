import carwash.*;
import simulator.*;

public class MainSim {
    public static void main(String[] args) {
        EventQueue eventQueue = new EventQueue();

        CarWashState cws = new CarWashState(eventQueue);
        CarWashView view = new CarWashView(cws);

        Simulator sim = new Simulator(eventQueue, cws, view);

        eventQueue.addEvent(new Start(0.0));
        eventQueue.addEvent(new Stop(15.0));

        sim.run();
    }
}
