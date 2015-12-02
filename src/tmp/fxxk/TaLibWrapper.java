package taLibWrapper;

import printer.CommandPrinter;

import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

public class TaLibWrapper implements CommandPrinter {

    private static final Core C = new Core();
    private static final CommandPrinter P = new CommandPrinter() {
    };

    public static void main(String[] args) {
        execute(() -> {
            int startIdx = 0;
            int endIdx = 399;
            double[] inReal = new double[400];
            int optInTimePeriod = 30;
            MInteger outBegIdx = new MInteger();
            MInteger outNBElement = new MInteger();
            double[] outReal = new double[400];
            RetCode sma = C.sma(
                    startIdx,
                    endIdx,
                    inReal,
                    optInTimePeriod,
                    outBegIdx,
                    outNBElement,
                    outReal);
            if (RetCode.Success == sma) {
                P.ln(outBegIdx.value);
                P.ln(outNBElement.value);
            }

            RetCode rsi = C.rsi(
                    startIdx,
                    endIdx,
                    inReal,
                    optInTimePeriod,
                    outBegIdx,
                    outNBElement,
                    outReal);
            if (RetCode.Success == rsi) {
                P.ln(outBegIdx.value);
                P.ln(outNBElement.value);
            }
            int optInFastPeriod = 100;
            int optInSlowPeriod = 100;
            int optInSignalPeriod = 100;
            double[] outMACD = new double[400];
            double[] outMACDSignal = new double[400];
            double[] outMACDHist = new double[400];
            RetCode macd = C.macd(
                    startIdx,
                    endIdx,
                    inReal,
                    optInFastPeriod,
                    optInSlowPeriod,
                    optInSignalPeriod,
                    outBegIdx,
                    outNBElement,
                    outMACD,
                    outMACDSignal,
                    outMACDHist);
            if (RetCode.Success == macd) {
                P.ln(outBegIdx.value);
                P.ln(outNBElement.value);
            }
        });
    }

    public static void execute(TaLib t) {
        t.run();
    }

    @FunctionalInterface
    interface TaLib {
        void run();
    }
}
