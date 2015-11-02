package pollseed.gof.singleton_abstractFactory;

import pollseed.gof.singleton_abstractFactory.interfaces.MathClient;

public class MathImpl implements MathClient {

    @Override
    public int multiply(final double target, final double withValue) {
        return (int) Math.pow(target, withValue);
    }
}
