package simulator;

import java.util.Observable;

public class SimState extends Observable {

    private static boolean isOn = true;


    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean runs) {
        isOn = runs;
    }

    public void observable(Event event) {
        setChanged();
        notifyObservers(event);
    }
}
