package carwash;

public class CarFactory {

    private static int carcounter = 0;

    public static Car createCar() {
        carcounter++;
        return new Car(carcounter);
    }
    public static int getCarCounter() {
        return carcounter;
    }
}
