package pollseed.tools.helper.interfaces;


import pollseed.tools.helper.abst.AnnotationController;
import pollseed.tools.helper.abst.AnnotationExecuterHelperWrapper;

/**
 * {@link AnnotationController#execute(AnnotationAction.AnnotationGenerator, Class)}
 * 実行時の処理を分岐させたい場合にこちらにルールを追加してください.<br>
 * <b>※このインタフェースを使用せず、{@link AnnotationExecuterHelperWrapper} を継承して下さい.</b> <br>
 * <br>
 * このインタフェースは、開発者が使用するものではなくただのルールです.
 *
 * @deprecated
 */
@Deprecated
public interface AnnotationExecuterHelper {

    /**
     * {@link AnnotationAction.ProcessTimer}
     *
     * @deprecated
     */
    @Deprecated
    void processTimerExecute();
}
