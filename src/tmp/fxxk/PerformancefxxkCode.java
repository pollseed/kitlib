package fxxk;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerformancefxxkCode {
    private static final int T = 10000;
    private static final PrintStream O = System.out;
    private static final Matcher M = Pattern.compile("hogehoge\\.fugafuga\\.piyopiyo\\.unchi=(ok|ng){1}((\\?ch\\[\\]=)([0-9])){0,1}").matcher(
            "hogehoge.fugafuga.piyopiyo.unchi=ok?ch[]=1");
    private static int __autoIncrement = 0;

    public static void main(final String[] args) {
        replaceFxxk();
        stringUnionFxxk();
    }

    private static void stringUnionFxxk() {
        b1();
        b2();
        b3();
    }

    private static void b3() {
        lngc(getTimes(() -> {
            StringBuffer unionWord = new StringBuffer();
            while (true) {
                unionWord.append("hoge");
                if (autoIncrementCheck())
                    break;
            }
        }));
    }

    private static void b2() {
        lngc(getTimes(() -> {
            StringBuilder unionWord = new StringBuilder();
            while (true) {
                unionWord.append("hoge");
                if (autoIncrementCheck())
                    break;
            }
        }));
    }

    private static void b1() {
        lngc(getTimes(() -> {
            @SuppressWarnings("unused")
            String unionWord = "";
            while (true) {
                unionWord += "hoge";
                if (autoIncrementCheck())
                    break;
            }
        }));
    }

    private static void replaceFxxk() {
        a1();
        a2();
        a3();
    }

    private static void a3() {
        lngc(getTimes(() -> {
            while (true) {
                l(M.replaceAll("hoge2.fuga2.piyo2.test=$1?ch{}=$2"));
                if (autoIncrementCheck())
                    break;
            }
        }));
    }

    private static void a2() {
        lngc(getTimes(() -> {
            while (true) {
                l("hogehoge.fugafuga.piyopiyo.unchi=ok?ch[]=1".replaceAll(
                        "hogehoge\\.fugafuga\\.piyopiyo\\.unchi=(ok|ng){1}((\\?ch\\[\\]=)([0-9])){0,1}", "hoge2.fuga2.piyo2.test=$1?ch{}=$2"));
                if (autoIncrementCheck())
                    break;
            }
        }));
    }

    private static void a1() {
        lngc(getTimes(() -> {
            while (true) {
                l("hogehoge.fugafuga.piyopiyo.unchi=ok?ch[]=1".replace("hogehoge", "hoge2").replace("fugafuga", "fuga2").replace("piyopiyo", "piyo2")
                        .replace("unchi", "test").replace("[]", "{}"));
                if (autoIncrementCheck())
                    break;
            }
        }));
    }

    private static boolean autoIncrementCheck() {
        __autoIncrement++;
        return __autoIncrement > T;
    }

    static void clean() {
        __autoIncrement = 0;
        System.gc();
    }

    static void l(final Object o) {
        O.print(o);
    }

    static void ln(final Object o) {
        O.println(o);
    }

    static void lngc(final Object o) {
        ln("");
        O.println(o);
        clean();
    }

    static long getTimes(final RunnerMain main) {
        final long before = System.currentTimeMillis();
        main.run();
        return System.currentTimeMillis() - before;
    }

    @FunctionalInterface
    public interface Runner {
        long getTimes(RunnerMain main);
    }

    @FunctionalInterface
    public interface RunnerMain {
        void run();
    }
}
