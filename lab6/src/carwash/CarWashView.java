package carwash;

import simulator.SimView;
import simulator.SimState;

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

    public void endPrint(){
        System.out.println("Rejected cars: " + CarWashState.rejected);
        System.out.println("Total Queue time " + CarWashState.queueTime);
        System.out.println("Total Idle time " + CarWashState.idleTime);
        System.out.println("Mean Queue Time " + CarWashState.meanQueueTime);
    }
}
