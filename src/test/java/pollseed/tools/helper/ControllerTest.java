package pollseed.tools.helper;

import org.junit.Assert;
import org.junit.Test;
import pollseed.tools.helper.interfaces.Action.ProcessTimer.Type;
import pollseed.tools.helper.interfaces.Action.Generator;
import pollseed.tools.helper.abst.Controller;

public class ControllerTest extends Controller implements Generator {
    public static void main(final String[] args) throws Exception {
        new ControllerTest().generate();
    }

    @ProcessTimer({ Type.MEASURE })
    @Override
    public void generate() throws Exception {
        System.out.println("generator");
        timer(new Generator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    Long.parseLong("1");
            }
        });
        timer(new Generator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    new Long("1");
            }
        });
        timer(new Generator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    Long.valueOf("1");
            }
        });
    }

    private void timer(final Generator preAction) throws Exception {
        execute(preAction, this.getClass());
    }
}
