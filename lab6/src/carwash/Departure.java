package carwash;

import simulator.Event;
import simulator.SimState;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Ett event som kontrollerar när bilar lämnar biltvätten och vilken tid.
 */

public class Departure extends Event {
    protected Car car;
    private String type;

    /**
     * Klassens konstruktor med parametrarna
     * @param car
     * @param time
     * @param type
     */

    public Departure(Car car,double time, String type) {
        super(time);
        this.car = car;
        this.type = type;
    }

    /**
     * Run metoden som implementeras från Event-klassen med parametern
     * @param state
     * Metoden håller koll på tiden och även uppdaterar den.
     * Den håller även koll på vilken maskin som bilen varit i och
     * ger plats för en nu bil i maskinen den var i.
     * Notifierar även observeraren som uppdaterar utskriften
     */

    @Override
    public void Run(SimState state) {
        CarWashState carWashState = (CarWashState) state;
        carWashState.currentTime = this.time;

        if (type.equals("fast")) {
            CarWashState.freeFast++;
        } else if (type.equals("slow")) {
            CarWashState.freeSlow++;
        }

        carWashState.updateQueueTime(this);
        carWashState.observable(this);

        carWashState.washing();

    }

}
