package simulator;

public class TestEvent extends Event {
    public TestEvent(double time) {
        super(time);
    }

    @Override
    public void Run(SimState state) {  // Ska vara "run", inte "Run"
        System.out.println("TestEvent executed at time: " + getTime());
    }
}