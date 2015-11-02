package src.main.adaptor;

public class Adaptor_Abstract_pattern {
    Adaptee adaptee;

    public Adaptor_Abstract_pattern() {
        adaptee = new Adaptee();
    }

    public int execute() {
        return adaptee.run();
    }
}
