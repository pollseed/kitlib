package pollseed.tools.helper.abst;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

/**
 * ファイルの解析をするための抽象クラス
 * 
 * not maintained future.
 */
public abstract class AbstractFileParser {

    protected String path = null;
    protected int cut = 0;
    protected String splits = "[,\n|\r\n 　]";

    protected AbstractFileParser(String path, int cut) {
        if (StringUtils.isBlank(path) || cut < 0) {
            throw new IllegalArgumentException();
        }
        this.path = path;
        this.cut = cut; // unsafe
    }

    protected AbstractFileParser(String path, int cut, String splits) {
        if (StringUtils.isBlank(path) || StringUtils.isBlank(splits) || cut < 0) {
            throw new IllegalArgumentException();
        }
        this.path = path;
        this.cut = cut; // unsafe
        this.splits = splits;
    }

    /**
     * 解析をして、{@link #path} に出力する
     * 
     * @param file
     */
    protected abstract void parse(File file);

}
