package carwash;

import simulator.Event;
import simulator.SimState;

public class Arrive extends Event {
    private Car car;
    static int carcounter = -1;


    public Arrive(double time, Car car) {
        super(time);
        this.car = car;

    }

    @Override
    public void Run(SimState state) {

        CarWashState carWashState = (CarWashState) state;
        CarQ queue = carWashState.getQueue();

        carWashState.updateIdleTime(this);
        carWashState.updateQueueTime(this);

        carWashState.currentTime = this.time;

        carcounter++;
        if (!queue.isFull()) {
            queue.addCar(this.car);
            if (carWashState.hasFreeMachines()) {
                carWashState.washing();
            } else {
                System.out.println("Bil lagd i kön " + carWashState.currentTime);
            }
        } else {
            CarWashState.rejected++;
            System.out.println("Rejected " + carWashState.currentTime);

        }
        carWashState.observable(this);
        carWashState.getArrivalTimes();
    }
}
