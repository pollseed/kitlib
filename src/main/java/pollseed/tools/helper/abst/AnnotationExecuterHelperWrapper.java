package pollseed.tools.helper.abst;

import pollseed.tools.helper.interfaces.AnnotationAction.ProcessTimer;

/**
 * {@link #AnnotationExecuterHelper()} のラッパークラスとなります.<br>
 * {@link #AnnotationExecuterHelper()}を実装せず、このクラスを継承して下さい.<br>
 */
public abstract class AnnotationExecuterHelperWrapper implements AnnotationExecuterHelper {
    @Override
    public void measureExecute() {
    }
}

/**
 * {@link AnnotationController#annotationExecuter(Class, ExecuterHelper)}
 * 実行時の処理を分岐させたい場合にこちらにルールを追加してください.<br>
 * <b>※このインタフェースを使用せず、{@link AnnotationExecuterHelperWrapper} を継承して下さい.</b> <br>
 * <br>
 * このインタフェースは、開発者が使用するものではなくただのルールです.
 *
 * @deprecated
 */
@Deprecated
interface AnnotationExecuterHelper {

    /**
     * {@link ProcessTimer}
     *
     * @deprecated
     */
    @Deprecated
    void measureExecute();
}
