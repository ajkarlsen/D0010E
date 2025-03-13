package simulator;

import java.util.PriorityQueue;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Skapar en "PriorityQueue" med typen "Event" med metoder som anropar till klassen "Event".
 */

public class EventQueue {

    PriorityQueue<Event> events = new PriorityQueue<>();

    public Event getEvent() {
        return events.poll();
    }

    /**
     * Lägger till event i event kön
     * @param event
     */
    public void addEvent(Event event) {
        events.add(event);
    }

}
