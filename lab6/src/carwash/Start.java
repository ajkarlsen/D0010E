package carwash;
import simulator.Event;
import simulator.SimState;

public class Start extends Event{

    public Start(double time) {
        super(time);
    }

    @Override
    public void Run(SimState state) {
        state.setOn(true);
        CarWashState carWashState = (CarWashState) state;
        carWashState.getArrivalTimes();
        carWashState.observable(this);
    }
}
