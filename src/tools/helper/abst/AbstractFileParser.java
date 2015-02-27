package abst;

import java.io.File;

/**
 * ファイルの解析をするための抽象クラス
 */
public abstract class AbstractFileParser {

    protected String path = null;
    protected int cut = 0;
    protected String splits = "[,\n|\r\n 　]";

    protected AbstractFileParser(String path, int cut) {
        this.path = path;
        this.cut = cut; // unsafe
    }

    protected AbstractFileParser(String path, int cut, String splits) {
        this.path = path;
        this.cut = cut; // unsafe
        this.splits = splits;
    }

    /**
     * 解析をして、{@link #path} に出力する
     * @param file
     */
    protected abstract void parse(File file);

}
