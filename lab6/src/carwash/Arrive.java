package carwash;

import simulator.Event;
import simulator.SimState;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Klassen som skapar Arrive eventet
 */

public class Arrive extends Event {
    /**
     * Håller koll på vilken bil och även hur många bilar som skapats
     */
    protected Car car;
    public static int carcounter;

    /**
     * Konstruktorn som använder,
     * @param time och
     * @param car
     */

    public Arrive(double time, Car car) {
        super(time);
        this.car = car;

    }

    /**
     * Run metoden som implementeras från Event klassen. Den tar paramtern
     * @param state
     * Metoden uppdaterar vad tiden är och säger till observeraren så att utskrift sker.
     * Den kollar även huruvida kön är full eller inte och lägger till bilen om kön inte
     * är full. Annars rejectar den bilen. Sedan gör den ett nytt Arrive-event
     */

    @Override
    public void Run(SimState state) {

        CarWashState carWashState = (CarWashState) state;

        CarQ queue = carWashState.getQueue();

        carWashState.updateIdleTime(this);
        carWashState.updateQueueTime(this);
        carWashState.observable(this);
        carWashState.currentTime = this.time;

        if (!queue.isFull()) {
            queue.addCar(this.car);
            carcounter++;
            if (carWashState.hasFreeMachines()) {
                carWashState.washing();
            }
        } else {
            CarWashState.rejected++;

        }
        carWashState.getArrivalTimes();
    }
}
