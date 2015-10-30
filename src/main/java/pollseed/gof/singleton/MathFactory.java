package src.main.singleton;

import java.io.Serializable;

public class MathFactory implements Serializable {

    public static MathClient getInstance() {
        return new MathImpl();
    }

    private MathFactory() {
        throw new AssertionError();
    }

}
