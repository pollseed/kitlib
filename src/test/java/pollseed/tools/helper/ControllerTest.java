package pollseed.tools.helper;

import org.junit.Assert;
import org.junit.Test;
import pollseed.tools.helper.abst.Controller;

import static pollseed.tools.helper.interfaces.Action.ProcessTimer.Type.MEASURE;

public class ControllerTest extends Controller {

    @Test
    public void test_generator() throws Exception {
        new ControllerTest().generator();
        Assert.assertTrue(true);
    }

    @ProcessTimer({MEASURE})
    @Override
    public void generator() throws Exception {
        System.out.println("generator");
        timer(new PreAction() {
            @Override
            public void generator() {
                for (int i = 0; i < 1000000; i++)
                    Long.parseLong("1");
            }
        });
        timer(new PreAction() {
            @Override
            public void generator() {
                for (int i = 0; i < 1000000; i++)
                    new Long("1");
            }
        });
        timer(new PreAction() {
            @Override
            public void generator() {
                for (int i = 0; i < 1000000; i++)
                    Long.valueOf("1");
            }
        });
    }

    private void timer(final PreAction preAction) throws Exception {
        run(preAction, this.getClass());
    }
}
