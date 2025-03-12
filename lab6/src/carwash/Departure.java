package carwash;

import simulator.Event;
import simulator.SimState;

public class Departure extends Event {
    protected Car car;
    private String type;

    public Departure(Car car,double time, String type) {
        super(time);
        this.car = car;
        this.type = type;
    }

    @Override
    public void Run(SimState state) {
        CarWashState carWashState = (CarWashState) state;
        carWashState.currentTime = this.time;

        // ✅ Se till att kön uppdateras korrekt innan vi ändrar storleken på maskinerna
        if (type.equals("fast")) {  // 🔥 Använd .equals() istället för ==
            CarWashState.freeFast++;
        } else if (type.equals("slow")) {
            CarWashState.freeSlow++;
        }

        // ✅ Uppdatera kö-tid EFTER att bilen har lämnat kön, men INNAN en ny bil börjar tvättas
        carWashState.updateQueueTime(this);
        carWashState.observable(this);

        carWashState.washing();

    }

}
