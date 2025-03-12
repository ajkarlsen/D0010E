package simulator;

import java.sql.Time;

public abstract class Event implements Comparable<Event> {

    public Double time;

    public Event(Double time) {
        this.time = time;
    }

    public Double getTime() {
        return time;
    }

    public abstract void Run(SimState state);

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time);
    }

}
