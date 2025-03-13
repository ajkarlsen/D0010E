package simulator;

import carwash.CarWashView;
import carwash.CarWashState;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Skapar instansmetoder av "EventQueue", "SimState" och "CarWashView" samt har metoden "run()" som startar
 * hela simulationen genom att anropa på metoder från klasserna "EventQueue", "SimState" och "CarWashView".
 */

public class Simulator {
    private EventQueue eventQueue;
    private SimState simState;
    private SimView simView;

    /**
     * Klassens som tar följande parametrar
     * @param eventQueue som är en kö för alla Event
     * @param simState som ska hålla koll på simuleringens "nuvarande" status
     * @param simView som är en abstrakt klass för att hålla koll på printklassen CarWashView
     */

    public Simulator(EventQueue eventQueue, SimState simState, SimView simView) {
        this.eventQueue = eventQueue;
        this.simState = simState;
        this.simView = simView;
    }

    /**
     * Run metod som kollar om det finns kommande Event
     * och avbryter programmet om det inte finns fler kommande Event
     */
    public void run() {
        simView.firstPrint();

        while (simState.isOn()) {
            Event event = eventQueue.getEvent();
            if (event == null) {
                System.out.println("No more events in queue. Stopping simulation.");
                break;
            }
            event.Run(simState);
        }
        simView.endPrint();
    }
}
