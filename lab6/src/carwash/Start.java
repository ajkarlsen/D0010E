package carwash;
import simulator.Event;
import simulator.SimState;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Startar simulationen genom att anropa "SimState" klassen och "CarWashState" och hämtar
 * tiderna som bilarna ska anlända.
 */

public class Start extends Event{

    public Start(double time) {
        super(time);
    }

    /**
     * Run metoden som sätter på simulationen och påbörjar skapelsen av Arrive-event.
     * Notifierar även observeraren som uppdaterar utskriften
     * @param state
     */

    @Override
    public void Run(SimState state) {
        state.setOn(true);
        CarWashState carWashState = (CarWashState) state;
        carWashState.getArrivalTimes();
        carWashState.observable(this);
    }
}
