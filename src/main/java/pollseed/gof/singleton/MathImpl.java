package src.main.singleton;

public class MathImpl implements MathClient {

    @Override
    public int multiply(final double target, final double withValue) {
        return (int) Math.pow(target, withValue);
    }
}
