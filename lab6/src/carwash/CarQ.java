package carwash;
import java.util.ArrayDeque;
import java.util.Queue;

public class CarQ {
    protected Queue<Car> q;

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
