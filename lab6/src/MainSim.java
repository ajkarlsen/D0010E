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
        eventQueue.addEvent(new Arrive(0.1, new Car(0)));
        eventQueue.addEvent(new Arrive(0.3, new Car(2)));
        eventQueue.addEvent(new Arrive(0.5, new Car(3)));
        eventQueue.addEvent(new Arrive(0.8, new Car(4)));
        eventQueue.addEvent(new Arrive(1.0, new Car(5)));
        eventQueue.addEvent(new Arrive(1.3, new Car(6)));
        eventQueue.addEvent(new Arrive(1.6, new Car(7)));
        eventQueue.addEvent(new Arrive(1.9, new Car(8)));
        eventQueue.addEvent(new Arrive(2.1, new Car(9)));
        eventQueue.addEvent(new Arrive(2.5, new Car(10)));
        eventQueue.addEvent(new Arrive(9.1, new Car(11)));
        eventQueue.addEvent(new Arrive(10.8, new Car(12)));

        eventQueue.addEvent(new Stop(15.0));
        // Kör simuleringen
        sim.run();
    }
}