package pollseed.gof.adaptor;

import pollseed.gof.adaptor.interfaces.IntrAdaptor;

public class Adaptor_Interface_pattern extends Adaptee implements IntrAdaptor {
    @Override
    public int execute() {
        return run();
    }
}
