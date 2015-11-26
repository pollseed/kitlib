package pollseed.tools.helper.abst;

import pollseed.tools.helper.interfaces.CommandPrinter;
import pollseed.tools.helper.interfaces.Runner;

import java.io.PrintStream;
import java.util.List;

/**
 * {@code main} メソッドのためのヘルパークラス
 *
 */
public abstract class AbstractMainHelper implements Runner, CommandPrinter {

    /**
     * 主処理を書きます.
     */
    protected abstract void run();

}
