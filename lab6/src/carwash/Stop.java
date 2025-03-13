package carwash;

import simulator.Event;
import simulator.SimState;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Ska avsluta simulationen genom att anropa klassen "SimState" och uppdaterar så tiderna är relevanta
 * vid simulationens avslut.
 */

public class Stop extends Event {

    public Stop(double time) {
        super(time);
    }


    @Override
    public void Run(SimState state) {
        state.setOn(false);
        CarWashState carWashState = (CarWashState) state;

        carWashState.updateQueueTime(this);
        carWashState.updateIdleTime(this);
        carWashState.meanQueueTime();

        carWashState.observable(this);

    }
}