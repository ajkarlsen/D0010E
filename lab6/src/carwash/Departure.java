package carwash;

import simulator.Event;
import simulator.SimState;

public class Departure extends Event {
    private Car car;
    private String type;

    public Departure(Car car,double time, String type) {
        super(time);
        this.car = car;
        this.type = type;
    }

    @Override
    public void Run(SimState state) {
        CarWashState carWashState = (CarWashState) state;

        carWashState.updateIdleTime(this);
        carWashState.updateQueueTime(this);

        carWashState.observable(this);
        carWashState.currentTime = this.time;

        if (type == "fast"){
            CarWashState.freeFast++;
            System.out.println("Bil lämnar snabb");
        } else if (type == "slow") {
            CarWashState.freeSlow++;
            System.out.println("Bil lämnar långsam");
        }
        carWashState.washing();

    }
}
