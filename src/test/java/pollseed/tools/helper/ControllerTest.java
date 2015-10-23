package pollseed.tools.helper;

import org.junit.Assert;
import org.junit.Test;
import pollseed.tools.helper.interfaces.AnnotationAction.ProcessTimer.Type;
import pollseed.tools.helper.interfaces.AnnotationAction.AnnotationGenerator;
import pollseed.tools.helper.abst.AnnotationController;
import pollseed.tools.exception.SilentException;

public class ControllerTest extends AnnotationController implements AnnotationGenerator {

    @Test
    public void test_processTimer() throws Exception {
        generate();
        Assert.assertTrue(true);
    }

    @ProcessTimer({Type.MEASURE})
    @Override
    public void generate() throws Exception {
        LOGGER.info("generator");
        timer(new AnnotationGenerator() {
            @Override
            public void generate() {
                for (int i = 0; i < 1000000; i++)
                    Long.parseLong("1");
            }
        });
        timer(new AnnotationGenerator() {
            @Override
            public void generate() throws SilentException {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        new Long("1");
                        if (i == 900000) {
                            new Long("hoge");
                        }
                    } catch (NumberFormatException e) {
                        throw new SilentException("hoge");
                    }
                }
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
