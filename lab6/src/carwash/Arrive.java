package carwash;

import simulator.Event;
import simulator.SimState;

public class Arrive extends Event {
    private Car car;


    public Arrive(double time, Car car) {
        super(time);
        this.car = car;

    }

    @Override
    public void Run(SimState state) {
        CarWashState carWashState = (CarWashState) state;
        CarQ queue = carWashState.getQueue();
        carWashState.currentTime = this.time;
        if (!queue.isFull()) {
            queue.addCar(this.car);
            if (carWashState.hasFreeMachines()) {
                carWashState.washing();
            } else {
                System.out.println("Bil lagd i kön");
            }
        } else {
            carWashState.rejected++;
            System.out.println("Rejected " + carWashState.currentTime);

        }
    }
}
