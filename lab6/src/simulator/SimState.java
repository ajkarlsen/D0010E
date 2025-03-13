package simulator;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Håller koll på var i simuleringen vi befinner oss
 */

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
