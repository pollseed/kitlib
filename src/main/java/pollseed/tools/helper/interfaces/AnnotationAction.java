package pollseed.tools.helper.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code Annotation} 機能を呼び起こすインタフェース.
 */
public interface AnnotationAction {

    /**
     * メイン処理
     *
     * @param actionGenerator
     *            {@link AnnotationGenerator}
     * @param clazz
     *            メイン処理を呼ぶ元クラス
     * @throws Exception
     *             例外時
     */
    <T> void execute(AnnotationGenerator actionGenerator, Class<T> clazz) throws Exception;

    /**
     * {@code AnnotationAction} を補佐するインタフェース<br>
     * {@code intercepter} として {@code Annotation} を機能させるために {@link #generate()}
     * を実装して下さい.
     */
    interface AnnotationGenerator {

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
     * {@code MEASURE} を指定した
     * {@link AnnotationAction#execute(AnnotationGenerator, Class)}
     * が呼ばれる度に時間計測をします.
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
