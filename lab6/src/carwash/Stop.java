package carwash;

import simulator.Event;
import simulator.SimState;

public class Stop extends Event {

    public Stop(double time) {
        super(time);
    }


    @Override
    public void Run(SimState state) {
        state.setOn(false);
        CarWashState carWashState = (CarWashState) state;

        carWashState.meanQueueTime(this);

        carWashState.updateQueueTime(this);
        carWashState.updateIdleTime(this);

        carWashState.observable(this);

    }
}