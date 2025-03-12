package carwash;

import simulator.Event;
import simulator.SimView;
import simulator.SimState;


import java.util.Observable;
import java.util.Observer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CarWashView extends SimView {
    CarWashState carWashState;

    public CarWashView(SimState simState) {
        super(simState);
        this.carWashState = (CarWashState) simState;


    }

    public void firstPrint(){
        System.out.println("Fast machines:" + CarWashState.fast);
        System.out.println("Slow Machines:" + CarWashState.slow);
        System.out.println("Distribution-rate fast machines: (" + CarWashState.fastLowDist + ", " + CarWashState.fastHighDist + ")");
        System.out.println("Distribution-rate slow machines: (" + CarWashState.slowLowDist + "," + CarWashState.slowHighDist + ")");
        System.out.println("Lambda skriv mer" + CarWashState.lambda);
        System.out.println("Seed = " + CarWashState.seed);
        System.out.println("Max queue size: " + CarWashState.maxQ);
        System.out.println("----------------------------------------\n");
    }

    @Override
    public void update(Observable o, Object obj){
        NumberFormat fmt = new DecimalFormat("#0.00");
        Event temp = (Event) obj;

        if (temp instanceof Arrive) {
            Arrive temp2 = (Arrive) temp;
            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    fmt.format(temp.time),
                    CarWashState.freeFast,
                    CarWashState.freeSlow,
                    temp2.car.id,
                    "Arrive",
                    fmt.format(CarWashState.idleTime),
                    fmt.format(CarWashState.queueTime),
                    CarQ.q.size(),
                    CarWashState.rejected);
        } else if (temp instanceof Departure) {
            Departure temp2 = (Departure) temp;

            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    fmt.format(temp.time),
                    CarWashState.freeFast,
                    CarWashState.freeSlow,
                    temp2.car.id,
                    "Leave",
                    fmt.format(CarWashState.idleTime),
                    fmt.format(CarWashState.queueTime),
                    CarQ.q.size(),
                    CarWashState.rejected);
        } else if (temp instanceof Stop) {
            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    fmt.format(temp.time),
                    CarWashState.freeFast,
                    CarWashState.freeSlow,
                    "-",
                    "Stop",
                    fmt.format(CarWashState.idleTime),
                    fmt.format(CarWashState.queueTime),
                    CarQ.q.size(),
                    CarWashState.rejected);
        } else if (temp instanceof Start) {
            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    "-",
                    "-",
                    "-",
                    "-",
                    "Start",
                    "-",
                    "-",
                    "-",
                    "-");
        }



    }

    public void endPrint(){
        System.out.println("\nRejected cars: " + CarWashState.rejected);
        System.out.println("Total Queue time " + CarWashState.queueTime);
        System.out.println("Total Idle time " + CarWashState.idleTime);
        System.out.println("Mean Queue Time " + CarWashState.meanQueueTime);
    }
}
