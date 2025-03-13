package carwash;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Alex Karlsen, Fabian Moestam, Sebastian Samuelsson
 * Klass som skapar kön av bilar och kollar om kön är full.
 */

public class CarQ {
    public static Queue<Car> q;

    public CarQ() {
        this.q = new ArrayDeque<>();
    }

    public Queue<Car> getQ() {
        return q;
    }

    public void addCar(Car car) {
        q.add(car);
    }

    public boolean isFull() {
        return q.size() >= CarWashState.maxQ;
    }

    public Car getNextCar() {
        return q.poll();
    }


}
