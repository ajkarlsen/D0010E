package simulator;

import java.sql.Time;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Abstrakt klass som tar in en tid där de event som ärver klassen blir tilldelade och
 * håller koll på vilket event som händer vid vilken tidpunkt.
 */

public abstract class Event implements Comparable<Event> {

    /**
     * Tids variabeln
     */
    public Double time;

    /**
     * Konstruktorn för klassen med parametern
     * @param time
     */
    public Event(Double time) {
        this.time = time;
    }

    /**
     * Getter för tiden så att den kan användas i andra klasser
     */

    public Double getTime() {
        return time;
    }

    /**
     * En abstrakt metod som implementeras i samtliga Event-klasser med
     * @param state som parameter
     */

    public abstract void Run(SimState state);

    /**
     *
     * @param other  the object to be compared.
     * @return
     */

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }

}
