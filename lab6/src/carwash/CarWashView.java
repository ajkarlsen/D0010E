package carwash;

import simulator.Event;
import simulator.SimView;
import simulator.SimState;


import java.util.Observable;
import java.util.Observer;

public class CarWashView extends SimView {
    CarWashState carWashState;
    Car car;

    public CarWashView(SimState carWashState) {
        super(carWashState);
    }

    public void firstPrint(){
        System.out.println("Fast machines:" + CarWashState.fast);
        System.out.println("Slow Machines:" + CarWashState.slow);
        System.out.println("Distribution-rate fast machines: (" + CarWashState.fastLowDist + ", " + CarWashState.fastHighDist + ")");
        System.out.println("Distribution-rate slow machines: (" + CarWashState.slowLowDist + "," + CarWashState.slowHighDist + ")");
        System.out.println("Lambda skriv mer" + CarWashState.lambda);
        System.out.println("Seed = " + CarWashState.seed);
        System.out.println("Max queue size: " + CarWashState.maxQ);
        System.out.println("----------------------------------------");
    }



    public void update(Observable obs, Object obj){

        Event temp = (Event) obj;

        if (temp instanceof Arrive) {
            System.out.print("Time " + carWashState.currentTime);
            System.out.print(" Event: Arrive");
            System.out.print(" id" + Arrive.carcounter);
            System.out.print(" Fast " + CarWashState.freeFast + " slow " + CarWashState.freeSlow);
            System.out.print(" Idle time " + CarWashState.idleTime + " Queue time " + CarWashState.queueTime );
            System.out.println(" Queue size " + carWashState.getQueue().q.size() + " rejected " + CarWashState.rejected);
        } else if (temp instanceof Departure) {
            System.out.print("Time " + carWashState.currentTime);
            System.out.print(" Event: Departure");
            System.out.print(" id" + Arrive.carcounter);
            System.out.print(" Fast " + CarWashState.freeFast + " slow " + CarWashState.freeSlow);
            System.out.print(" Idle time " + CarWashState.idleTime + " Queue time " + CarWashState.queueTime );
            System.out.println(" Queue size " + carWashState.getQueue().q.size() + " rejected " + CarWashState.rejected);
        } else if (temp instanceof Stop) {
            System.out.print("Time " + carWashState.currentTime);
            System.out.print(" Event: Stop");
            System.out.print(" Fast " + CarWashState.freeFast + " slow " + CarWashState.freeSlow);
            System.out.print(" Idle time " + CarWashState.idleTime + " Queue time " + CarWashState.queueTime );
            System.out.println(" Queue size " + carWashState.getQueue().q.size() + " rejected " + CarWashState.rejected);
        } else if (temp instanceof Start) {
            System.out.print("Time " + carWashState.currentTime);
            System.out.print(" Event: Start");
        }



    }

    public void endPrint(){
        System.out.println("Rejected cars: " + CarWashState.rejected);
        System.out.println("Total Queue time " + CarWashState.queueTime);
        System.out.println("Total Idle time " + CarWashState.idleTime);
        System.out.println("Mean Queue Time " + CarWashState.meanQueueTime);
    }
}
