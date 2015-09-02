package pollseed.tools.helper.interfaces;

import java.util.List;

/**
 * コマンドプリンター
 */
public interface CommandPrinter {

    /**
     * 引数を埋め込んで返す.
     *
     * @param origin
     *            元データ
     * @param embedded
     *            埋め込み引数
     * @return 埋め込みデータ
     */
    String printf(String origin, String embedded);

    /**
     * {@code obj}をコマンドラインに出力して改行する.
     *
     * @param obj
     *            出力したいデータ
     */
    void ln(Object obj);

    /**
     * {@code obj}をコマンドラインに出力する.
     *
     * @param obj
     *            出力したいデータ
     */
    void l(Object obj);

    /**
     * ラインをコマンドラインに出力する.
     */
    void lnLine();

    /**
     * {@code obj}をコマンドラインに出力し、ラインで囲む.
     *
     * @param obj
     *            出力したいデータ
     */
    void lnLine(Object obj);

    /**
     * {@code list}をそれぞれコマンドラインに出力して改行する.
     *
     * @param list
     *            出力したいデータ
     */
    void lnList(List<? extends Object> list);

}
