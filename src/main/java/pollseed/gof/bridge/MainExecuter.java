package pollseed.gof.bridge;

import pollseed.gof.bridge.interfaces.Compartment;

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
