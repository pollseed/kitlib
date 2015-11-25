package fxxk.abst;

import java.io.PrintStream;

import fxxk.abst.AbstractTestAggregation.ParseTest.ValidateProcess;

public abstract class AbstractTestAggregation {
    protected AbstractTestAggregation() {
    }

    protected static ParseTest __executer = null;

    protected final static void ln(final Object obj) {
        O.println(obj);
    }

    protected final static void ln(final Object obj, final ValidateProcess p) throws Exception {
        ln(obj + " 【Start】");
        try {
            p.execute();
        } catch (final Exception e) {
            ln(obj + " 【Error】");
            throw e;
        }
        ln(obj + " 【Finale】");
    }

    protected interface ParseTest {
        void executeErrorProcess() throws Exception;

        void executeProcess() throws Exception;

        @FunctionalInterface
        interface ValidateProcess {
            void execute();
        }
    }

    private static final PrintStream O = System.out;
}
