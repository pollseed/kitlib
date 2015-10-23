package pollseed.tools.helper;

import org.junit.Assert;
import org.junit.Test;
import pollseed.tools.helper.interfaces.AnnotationAction.ProcessTimer.Type;
import pollseed.tools.helper.interfaces.AnnotationAction.AnnotationGenerator;
import pollseed.tools.helper.abst.AnnotationController;

public class ControllerTest extends AnnotationController implements AnnotationGenerator {

    @Test
    public void test_processTimer() throws Exception {
        generate();
        Assert.assertTrue(true);
    }

    @ProcessTimer({ Type.MEASURE })
    @Override
    public void generate() throws Exception {
        __logger.info("generator");
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

    private void timer(final AnnotationGenerator annotationGenerator) throws Exception {
        execute(annotationGenerator, this.getClass());
    }
}
