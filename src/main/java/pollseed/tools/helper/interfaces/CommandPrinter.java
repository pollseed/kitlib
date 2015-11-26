package pollseed.tools.helper.interfaces;

import java.io.PrintStream;
import java.util.List;

/**
 * コマンドプリンター
 */
public interface CommandPrinter {
    /** 出力用の線. */
    static final String LINE = "-------------";
    /** 出力. */
    static final PrintStream O = System.out;

    /**
     * 引数を埋め込んで返す.
     *
     * @param origin
     *            書式文字元データ
     * @param embedded
     *            埋め込み引数
     * @return 埋め込みデータ
     */
    default String printf(final String origin, final String embedded) {
        return String.format(origin, embedded);
    }

    /**
     * {@code obj}をコマンドラインに出力して改行する.
     *
     * @param obj
     *            出力したいデータ
     */
    default void ln(final Object obj) {
        O.println(obj);
    }

    /**
     * {@code obj}をコマンドラインに出力する.
     *
     * @param obj
     *            出力したいデータ
     */
    default void l(final Object obj) {
        O.print(obj);
    }

    /**
     * ラインをコマンドラインに出力する.
     */
    default void lnLine() {
        ln(LINE);
    }

    /**
     * {@code obj}をコマンドラインに出力し、ラインで囲む.
     *
     * @param obj
     *            出力したいデータ
     */
    default void lnLine(final Object obj) {
        lnLine();
        ln(obj);
        lnLine();
    }

    /**
     * {@code list}をそれぞれコマンドラインに出力して改行する.
     *
     * @param list
     *            出力したいデータ
     */
    default void lnList(final List<? extends Object> list) {
        list.forEach(obj -> ln(obj));
    }
}
