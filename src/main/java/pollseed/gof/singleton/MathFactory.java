package pollseed.gof.singleton;

import java.io.Serializable;

import pollseed.gof.singleton.interfaces.MathClient;

public class MathFactory implements Serializable {
    private static final long serialVersionUID = 1L;

    public static MathClient getInstance() {
        return new MathImpl();
    }

    private MathFactory() {
        throw new AssertionError();
    }

}
