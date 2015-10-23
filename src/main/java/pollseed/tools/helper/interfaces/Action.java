package pollseed.tools.helper.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * アクションインタフェース
 */
public interface Action {

    /**
     * メイン処理
     *
     * @param preAct
     *            {@link Generator}
     * @param claz
     *            メイン処理を呼ぶ元クラス
     * @throws Exception
     *             例外時
     */
    <T> void execute(Generator preAct, Class<T> claz) throws Exception;

    // TODO 問題がなければ消す. *******
    // /**
    // * @deprecated
    // */
    // @Deprecated
    // <T> void before(Class<T> claz) throws Exception;
    // /**
    // * @deprecated
    // */
    // @Deprecated
    // <T> void after(Class<T> claz);
    // *******

    /**
     * アクションを補佐するインタフェース<br>
     * {@code intercepter} として {@code Annotation} を機能させるために {@link #generate()} を実装して下さい.
     */
    interface Generator {

        /**
         * {@code Annotation} 処理の中に入り込む実装メソッド
         *
         * @throws Exception
         *             例外時
         */
        void generate() throws Exception;

    }

    // TODO {@code Annotation} が増えてきたらヘッダファイルとして切り出す.

    /**
     * 時間計測用の {@code Annotation} <br>
     * {@code MEASURE} を指定した {@link Action#execute(Generator, Class)} が呼ばれる度に時間計測をします.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface ProcessTimer {
        enum Type {
            MEASURE, NONE
        }

        Type[] value() default Type.NONE;
    }

}

