package simulator;

import java.util.Observer;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Abstrakt klass som skapar metoder åt "CarWashView" klassen och lägger till en observer till
 * instansvaribeln "simState" i konstruktorn.
 */

public abstract class SimView implements Observer {

    protected SimState simState;

    public SimView(SimState simState) {
        this.simState = simState;
        simState.addObserver(this);
    }


    public abstract void firstPrint();
    public abstract void endPrint();
}
