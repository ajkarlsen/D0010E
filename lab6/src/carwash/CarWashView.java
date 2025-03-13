package carwash;

import simulator.Event;
import simulator.SimView;
import simulator.SimState;


import java.util.Observable;
import java.util.Observer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Denna klass är själva utskriften.
 *
 */

public class CarWashView extends SimView {
    CarWashState carWashState;

    /**
     *Klassens konstruktor som skapar en ny CarWashView och kopplar den till simState
     * @param simState Är vad som håller koll på var i simuleringen vi befinner oss
     */

    public CarWashView(SimState simState) {
        super(simState);
    }

    /**
     * Är den första utskriften som t.ex. hur många snabba tvättmaskiner som finns
     */

    public void firstPrint(){
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("Fast machines:" + CarWashState.fast);
        System.out.println("Slow Machines:" + CarWashState.slow);
        System.out.println("Distribution-rate fast machines: (" + CarWashState.fastLowDist + ", " + CarWashState.fastHighDist + ")");
        System.out.println("Distribution-rate slow machines: (" + CarWashState.slowLowDist + ", " + CarWashState.slowHighDist + ")");
        System.out.println("Exponential distribution with lambda =  " + CarWashState.lambda);
        System.out.println("Seed = " + CarWashState.seed);
        System.out.println("Max queue size: " + CarWashState.maxQ);
        System.out.println("----------------------------------------");
        System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                "Time",
                "Event",
                "Id",
                "Fast",
                "Slow",
                "IdleTime",
                "QueueTime",
                "QueueSize",
                "Rejected");
    }

    /**
     * Uppdaterar utskriften vid ett nytt Event.
     * Den formatterar även utskriften på ett önskevärt sätt
     *
     * @param o     the observable object.
     * @param obj   an argument passed to the {@code notifyObservers}
     *                 method.
     */


    @Override
    public void update(Observable o, Object obj){
        NumberFormat formatter = new DecimalFormat("#0.00");
        Event temp = (Event) obj;

        if (temp instanceof Arrive) {
            Arrive temp2 = (Arrive) temp;
            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    formatter.format(temp.time),
                    "Arrive",
                    temp2.car.id,
                    CarWashState.freeFast,
                    CarWashState.freeSlow,
                    formatter.format(CarWashState.idleTime),
                    formatter.format(CarWashState.queueTime),
                    CarQ.q.size(),
                    CarWashState.rejected);
        } else if (temp instanceof Departure) {
            Departure temp2 = (Departure) temp;

            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    formatter.format(temp.time),
                    "Leave",
                    temp2.car.id,
                    CarWashState.freeFast,
                    CarWashState.freeSlow,
                    formatter.format(CarWashState.idleTime),
                    formatter.format(CarWashState.queueTime),
                    CarQ.q.size(),
                    CarWashState.rejected);
        } else if (temp instanceof Stop) {
            System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
                    formatter.format(temp.time),
                    "Stop",
                    " ",
                    CarWashState.freeFast,
                    CarWashState.freeSlow,
                    formatter.format(CarWashState.idleTime),
                    formatter.format(CarWashState.queueTime),
                    CarQ.q.size(),
                    CarWashState.rejected);
        } else if (temp instanceof Start) {
            System.out.printf("%-5s %6s\n",
                    formatter.format(temp.time),
                    "Start");
        }
    }

    /**
     * Printsatsen i slutet där t.ex. Antalet rejectade bilar skrivs ut.
     */

    public void endPrint(){
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("---------------------------------");
        System.out.println("Total Queue time " + formatter.format(CarWashState.queueTime));
        System.out.println("Total Idle time " + formatter.format(CarWashState.idleTime));
        System.out.println("Mean Queue Time " + formatter.format(CarWashState.meanQueueTime));
        System.out.println("Rejected cars: " + CarWashState.rejected);

    }
}
