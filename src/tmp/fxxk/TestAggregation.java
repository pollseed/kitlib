package tmp.fxxk;

import tmp.fxxk.abst.AbstractTestAggregation;

public final class TestAggregation extends AbstractTestAggregation {
    private static void errorGenerator() {
        setExecuter();
        try {
            __executer.executeProcess();
            __executer.executeErrorProcess();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static void setExecuter() {
        __executer = new ParseTest() {
            @Override
            public void executeErrorProcess() throws Exception {
                ln("executeErrorProcess", new ValidateProcess() {
                    @Override
                    public void execute() {
                        Integer.parseInt(Long.toString(Long.MAX_VALUE));
                    }
                });
            }

            @Override
            public void executeProcess() throws Exception {
                ln("executeProcess", new ValidateProcess() {
                    @Override
                    public void execute() {
                        Long.parseLong(Long.toString(Long.MAX_VALUE));
                    }
                });
            }
        };
    }

    // Exceptionを伝播させないで下さい
    public static void main(final String[] args) {
        errorGenerator();
    }
}
