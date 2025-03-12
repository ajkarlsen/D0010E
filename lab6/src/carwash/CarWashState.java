package carwash;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import simulator.Event;
import simulator.SimState;
import simulator.EventQueue;
import simulator.Simulator;

import java.util.Queue;

public class CarWashState extends SimState {
    private CarQ queue = new CarQ();
    static int fast = 2;
    static int slow = 2;
    static int freeFast = 2;
    static int freeSlow = 2;

    static double fastLowDist = 2.8;
    static double fastHighDist = 4.6;
    static double slowLowDist = 4.5;
    static double slowHighDist = 6.5;

    static int seed = 1234;
    static double lambda = 2.0;
    private int id = 0;


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

    public double currentTime;

    public CarWashState(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
        fastWashTimeGenerator = new UniformRandomStream(fastLowDist, fastHighDist, seed);  // För snabb tvätt
        slowWashTimeGenerator = new UniformRandomStream(slowLowDist, slowHighDist, seed);
        nextArrival = new ExponentialRandomStream(lambda, seed);
        this.currentTime = 0.0;
    }

    void updateIdleTime(Event e) {
        idleTime += (e.getTime()-prevCurrentTime) * (freeFast + freeSlow);
        prevCurrentTime = e.getTime();
    }

    void updateQueueTime(Event e) {
        queueTime += (e.getTime() - prevQueueTime) * getQueue().q.size();
        prevQueueTime = e.getTime();
    }

    void meanQueueTime(Event e) {
        meanQueueTime = queueTime/(Arrive.carcounter-rejected);
    }

    public void scheduleArrival(double time, Car car) {
        eventQueue.addEvent(new Arrive(time, car));
    }

    public void getArrivalTimes() {
        double eventTime = nextArrival.next();
        scheduleArrival(currentTime + eventTime, new Car(id));
        id++;
    }

    public CarQ getQueue() {
        return queue;
    }
    public boolean hasFreeMachines() {
        if (freeFast != 0 || freeSlow != 0) {
            return true;
        }
        return false;
    }


    public void washing(){
        Car nextCar = queue.getNextCar();
        if(nextCar != null){
            if (freeFast > 0 ){
                System.out.println("Bil börjar tvättas snabbt " + currentTime);
                freeFast--;
                double washTime = fastWashTimeGenerator.next();
                scheduleDeparture(nextCar, washTime, "fast");

            } else if (freeSlow > 0) {
                System.out.println("Bil tvättas långsamt" + currentTime);
                freeSlow --;
                double washTime = slowWashTimeGenerator.next();
                scheduleDeparture(nextCar, washTime, "slow");
            }
        }
    }

    public void scheduleDeparture(Car car, double washTime, String type){
        double departureTime = currentTime + washTime;
        eventQueue.addEvent(new Departure(car, departureTime, type));
    }





}
