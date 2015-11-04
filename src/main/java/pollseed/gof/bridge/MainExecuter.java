package src.main;

public class MainExecuter implements Compartment {
    private Compartment c;

    public MainExecuter(Compartment c) {
        this.c = c;
    }

    @Override
    public void execute() {
        c.execute();
    }
}
