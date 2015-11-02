package pollseed.gof;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import pollseed.gof.conposit.Directory;
import pollseed.gof.conposit.File;
import pollseed.gof.conposit.abst.Root;
import pollseed.gof.singleton.MathFactory;
import pollseed.gof.singleton.interfaces.MathClient;

public class GofTest extends AbstractMain {

    @Test
    public void test_composit_pattern() {
        @SuppressWarnings("serial")
        final Directory directory = new Directory(Collections.unmodifiableCollection(new ArrayList<Root>() {
            {
                add(new File("hoge"));
                add(new File("hoge1"));
                add(new File("hoge2"));
                add(new File("hoge3"));
                add(new File("hoge4"));
            }
        }));
        eq(directory.getName(), "hoge:hoge1:hoge2:hoge3:hoge4");
        eq(directory.getSize(), 5);
    }

    @Test
    public void test_singletom_pattern() {
        final MathClient client = MathFactory.getInstance();
        eq(client.multiply(10, 2), 100);
    }
    
    @Test
    public void test_adaptor_pattern() {
        final IntrAdaptor adaptor_intr = new Adaptor_Interface_pattern();
        eq(adaptor_intr.execute(), 1);
        final Adaptor_Abstract_pattern adaptor_abst = new Adaptor_Abstract_pattern();
        eq(adaptor_abst.execute(), 1);
    }

    @Test
    public void bridge_pattern() {
        final AbstractBridge abstractBridgeA = new Bridge(new BridgeImplA());
        eq(abstractBridgeA.execute(), "execute BridgeImplA");
        final AbstractBridge abstractBridgeB = new Bridge(new BridgeImplB());
        eq(abstractBridgeB.execute(), "execute BridgeImplB");
        final Bridge bridge = new Bridge();
        eq(bridge.executeBridge(), "execute Bridge");
    }
}
