package main.common;

import java.io.PrintStream;
import java.util.List;

/**
 * {@code main} メソッドのためのヘルパークラス
 *
 */
public abstract class MainHelper implements Runner, CommandPrinter {

    /**
     * 主処理を書きます.
     */
    protected abstract void run();

    @Override
    public long getTimes(RunnerMain main) {
        long before = System.currentTimeMillis();
        main.run();
        return System.currentTimeMillis() - before;
    }

    @Override
    public String printf(String origin, String embedded) {
        return String.format(origin, embedded);
    }

    @Override
    public void ln(Object obj) {
        out().println(obj);
    }

    @Override
    public void l(Object obj) {
        out().print(obj);
    }

    private final PrintStream out() {
        return System.out;
    }

    @Override
    public void lnLine() {
        ln("-------------");
    }

    @Override
    public void lnLine(Object obj) {
        lnLine();
        ln(obj);
        lnLine();
    }

    @Override
    public void lnList(List<? extends Object> list) {
        for (Object obj : list) {
            ln(obj);
        }
    }
}
