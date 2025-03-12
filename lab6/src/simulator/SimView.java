package simulator;

public abstract class SimView {

    protected SimState simState;

    public SimView(SimState simState) {
        this.simState = simState;
    }

    public abstract void firstPrint();
    public abstract void endPrint();
}
