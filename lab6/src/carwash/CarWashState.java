package carwash;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.Event;
import simulator.SimState;
import simulator.EventQueue;
import simulator.Simulator;

import java.util.Queue;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Klassen håller koll på om biltvätten används och hur lång tid varje tvätt tar och vilken tid
 * bilen lämnar tvätten samt anländer till tvätten
 */

public class CarWashState extends SimState {
    private CarQ queue = new CarQ();
    static int fast = 2;
    static int slow = 2;
    static int freeFast = 2;
    static int freeSlow = 2;

    static double fastLowDist = 2.8;
    static double fastHighDist = 4.6;
    static double slowLowDist = 3.5;
    static double slowHighDist = 6.7;

    static int seed = 1234;
    static double lambda = 2.0;
    private int id = -1;


    static int maxQ = 5;
    static int rejected = 0;
    private EventQueue eventQueue;

    static double queueTime = 0;
    static double idleTime = 0;
    private double prevQueueTime = 0;
    private double prevCurrentTime = 0;
    static double meanQueueTime;

    private UniformRandomStream fastWashTimeGenerator;
    private UniformRandomStream slowWashTimeGenerator;
    private ExponentialRandomStream nextArrival;

    protected double currentTime;

    /**
     * Konstruktor som tar fram slumtalen för tvätttider och ankomsttider.
     * @param eventQueue
     */
    public CarWashState(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        fastWashTimeGenerator = new UniformRandomStream(fastLowDist, fastHighDist, seed);  // För snabb tvätt
        slowWashTimeGenerator = new UniformRandomStream(slowLowDist, slowHighDist, seed);
        nextArrival = new ExponentialRandomStream(lambda, seed);
        this.currentTime = 0.0;
    }

    /**
     * Getter för bilkön
     * @return
     */
    public CarQ getQueue() {
        return queue;
    }


    /**
     * Uppdaterar idletiden baserat på vilken tid eventet hänt.
     * @param e
     */
    void updateIdleTime(Event e) {
        idleTime += (e.getTime()-prevCurrentTime) * (freeFast + freeSlow);
        prevCurrentTime = e.getTime();
    }

    /**
     * Uppdaterar den totala kötiden
     * @param e
     */
    void updateQueueTime(Event e) {
        queueTime += (e.getTime() - prevQueueTime) * CarQ.q.size();
        prevQueueTime = e.getTime();
    }

    /**
     * Räknar ut snittet för kötiden
     */
    void meanQueueTime() {
        meanQueueTime = queueTime/Arrive.carcounter;
    }

    /**
     * Skapar ett nytt arrival-event till eventkön
     * @param time
     * @param car
     */
    public void scheduleArrival(double time, Car car) {
        eventQueue.addEvent(new Arrive(time, car));
    }

    /**
     * Tar fram tiden för nästa arrival och schemalägger den.
     */
    public void getArrivalTimes() {
        double eventTime = nextArrival.next();
        id++;
        scheduleArrival(currentTime + eventTime, new Car(id));
    }

    /**
     * Kollar om lediga maskiner finns
     * @return
     */
    public boolean hasFreeMachines() {
        if (freeFast != 0 || freeSlow != 0) {
            return true;
        }
        return false;
    }

    /**
     * Tvättar bilar och schemalägger departure
     */
    public void washing(){
        Car nextCar = queue.getNextCar();
        if(nextCar != null){
            if (freeFast > 0 ){
                double washTime = fastWashTimeGenerator.next();
                scheduleDeparture(nextCar, washTime, "fast");
                freeFast--;

            } else if (freeSlow > 0) {
                double washTime = slowWashTimeGenerator.next();
                scheduleDeparture(nextCar, washTime, "slow");
                freeSlow --;

            }
        }
    }

    /**
     * Skapar nya departure-event
     * @param car
     * @param washTime
     * @param type
     */
    public void scheduleDeparture(Car car, double washTime, String type){
        double departureTime = currentTime + washTime;
        eventQueue.addEvent(new Departure(car, departureTime, type));
    }
}
