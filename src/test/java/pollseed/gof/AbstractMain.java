package pollseed.gof;

public abstract class AbstractMain {
    protected static final void eq(Object a, Object b) {
        org.junit.Assert.assertEquals(a, b);
    }
}
