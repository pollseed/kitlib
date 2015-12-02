package taLibWrapper;

import printer.CommandPrinter;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

/**
 * 1.C++だけど、このドキュメントを参考にした
 * http://ta-lib.org/d_api/d_api.html
 * 
 * 2.build.gradleに以下追記
 * compile 'com.tictactec:ta-lib:0.4.0'
 * 
 **/
public class TaLibWrapper implements CommandPrinter {

    private static final Core C = new Core();
    private static final CommandPrinter P = new CommandPrinter() {
    };

    private static MInteger __outBegIdx = new MInteger();
    private static MInteger __outNBElement = new MInteger();

    private static class StandardVal {
        private static final int START_IDX = 0;
        private static final int END_IDX = 399;
        private static final double[] IN_REAL = new double[400];
        private static final int OPT_IN_TIME_PERIOD = 30;
        private static final double[] OUT_REAL = new double[400];
    }

    public static class AdvancedVal {
        private static final int OPT_IN_FAST_PERIOD = 100;
        private static final int OPT_IN_SLOW_PERIOD = 100;
        private static final int OPT_IN_SIGNAL_PERIOD = 100;
        private static final int OPT_IN_TIME_PERIOD = 100;
        private static final double[] OUT_MACD = new double[400];
        private static final double[] OUT_MACD_SIGNAL = new double[400];
        private static final double[] OUT_MACD_HIST = new double[400];
    }

    public static void main(String[] args) {
        execute(() -> {
            return C.sma(
                    StandardVal.START_IDX,
                    StandardVal.END_IDX,
                    StandardVal.IN_REAL,
                    StandardVal.OPT_IN_TIME_PERIOD,
                    __outBegIdx,
                    __outNBElement,
                    StandardVal.OUT_REAL);
        });
        execute(() -> {
            return C.rsi(
                    StandardVal.START_IDX,
                    StandardVal.END_IDX,
                    StandardVal.IN_REAL,
                    StandardVal.OPT_IN_TIME_PERIOD,
                    __outBegIdx,
                    __outNBElement,
                    StandardVal.OUT_REAL);
        });
        execute(() -> {
            return C.macd(
                    StandardVal.START_IDX,
                    StandardVal.END_IDX,
                    StandardVal.IN_REAL,
                    AdvancedVal.OPT_IN_FAST_PERIOD,
                    AdvancedVal.OPT_IN_SLOW_PERIOD,
                    AdvancedVal.OPT_IN_SIGNAL_PERIOD,
                    __outBegIdx,
                    __outNBElement,
                    AdvancedVal.OUT_MACD,
                    AdvancedVal.OUT_MACD_SIGNAL,
                    AdvancedVal.OUT_MACD_HIST);
        });
        execute(() -> {
            return C.movingAverage(StandardVal.START_IDX,
                    StandardVal.END_IDX,
                    StandardVal.IN_REAL,
                    AdvancedVal.OPT_IN_TIME_PERIOD,
                    MAType.Kama,
                    __outBegIdx,
                    __outNBElement,
                    StandardVal.OUT_REAL);
        });
    }

    public static void execute(TaLib t) {
        if (RetCode.Success == t.run()) {
            P.ln(__outBegIdx.value);
            P.ln(__outNBElement.value);
        }
    }

    @FunctionalInterface
    interface TaLib {
        RetCode run();
    }
}
