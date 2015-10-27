package pollseed.gof.conposit.abst;

import org.junit.Assert;

public abstract class AbstractMain {
    protected final void eq(Object a, Object b) {
        Assert.assertEquals(a, b);
    }
}
