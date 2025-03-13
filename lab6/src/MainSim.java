import carwash.*;
import simulator.*;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Skapar instansvariabler av metoderna samt ger en tid till start och stop som tyder på när
 * programmet ska starta respektive avlsuta. Startar simulationen genom att anropa "run()" metoden i
 * "Simulator" klassen.
 */

public class MainSim {

    /**
     * Huvudmetod som skapar en Eventkö, CarWashState, CarWashView samt Simulator.
     * Den startar också programmet genom att lägga till ett event och avbryter
     * med ett annat event
     */
    public static void main(String[] args) {
        EventQueue eventQueue = new EventQueue();

        CarWashState carWashState = new CarWashState(eventQueue);
        CarWashView carWashview = new CarWashView(carWashState);

        Simulator sim = new Simulator(eventQueue, carWashState, carWashview);

        eventQueue.addEvent(new Start(0.0));
        eventQueue.addEvent(new Stop(15.0));

        sim.run();
    }
}
