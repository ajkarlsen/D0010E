package simulator;

import java.util.PriorityQueue;

public class EventQueue {

    PriorityQueue<Event> events = new PriorityQueue<>();

    public PriorityQueue<Event> getEvents() {
        return events;
    }

    public Event getEvent() {
        return events.poll();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }
}
