package test.controller;

import main.controller.Action.ProcessTimer.Type;
import main.controller.Controller;

public class TestController extends Controller {
    public static void main(final String[] args) throws Exception {
        new TestController().generator();
    }

    @ProcessTimer({ Type.MEASURE })
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
