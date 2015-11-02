package pollseed.gof.adaptor;

import pollseed.gof.adaptor.abst.AbstractAdaptor;

public class Adaptor_Abstract_pattern extends AbstractAdaptor {
    Adaptee adaptee;

    public Adaptor_Abstract_pattern() {
        adaptee = new Adaptee();
    }

    @Override
    public int execute() {
        return adaptee.run();
    }
}
