package pollseed.gof.singleton;

import pollseed.gof.singleton.interfaces.MathClient;

public class MathImpl implements MathClient {

    @Override
    public int multiply(final double target, final double withValue) {
        return (int) Math.pow(target, withValue);
    }
}
