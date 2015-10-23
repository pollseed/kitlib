package pollseed.tools.helper;

import org.junit.Assert;
import org.junit.Test;
import pollseed.tools.helper.interfaces.AnnotationAction.ProcessTimer.Type;
import pollseed.tools.helper.interfaces.AnnotationAction.AnnotationGenerator;
import pollseed.tools.helper.abst.AnnotationController;

public class TestController extends AnnotationController implements AnnotationGenerator {
    public static void main(final String[] args) throws Exception {
        new TestController().generate();
    }

    @ProcessTimer({ Type.MEASURE })
    @Override
    public void generate() throws Exception {
        System.out.println("generator");
        timer(new AnnotationGenerator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    Long.parseLong("1");
            }
        });
        timer(new AnnotationGenerator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    new Long("1");
            }
        });
        timer(new AnnotationGenerator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    Long.valueOf("1");
            }
        });
    }

    private void timer(final AnnotationGenerator preAction) throws Exception {
        execute(preAction, this.getClass());
    }
}

