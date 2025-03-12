package carwash;

public class CarFactory {

    private static int carcounter = -1;

    public static Car createCar() {
        carcounter++;
        return new Car(carcounter);
    }
    public static int getCarCounter() {
        return carcounter;
    }
}
