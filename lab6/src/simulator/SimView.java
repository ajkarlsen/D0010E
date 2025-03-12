package simulator;

import java.util.Observer;

public abstract class SimView implements Observer {

    protected SimState simState;

    public SimView(SimState simState) {
        this.simState = simState;
        simState.addObserver(this);
    }


    public abstract void firstPrint();
    public abstract void endPrint();
}
