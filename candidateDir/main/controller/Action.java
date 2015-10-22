package main.controller;

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
     *            {@link PreAction}
     * @param claz
     *            メイン処理を呼ぶ元クラス
     * @throws Exception
     *             例外時
     */
    <T> void run(PreAction preAct, Class<T> claz) throws Exception;

    /**
     * @deprecated
     */
    @Deprecated
    <T> void before(Class<T> claz) throws Exception;

    /**
     * @deprecated
     */
    @Deprecated
    <T> void after(Class<T> claz);

    /**
     * アクションを補佐するインタフェース
     */
    interface PreAction {

        /**
         * 実装メソッド
         *
         * @throws Exception
         *             例外時
         */
        void generator() throws Exception;

    }

    /**
     * 時間計測用の {@code Annotation} <br>
     * {@code MEASURE} を指定した {@link Action#run(PreAction, Class)} が呼ばれる度に時間計測をします.
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
