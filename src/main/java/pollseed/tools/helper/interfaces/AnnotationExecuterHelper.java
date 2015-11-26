package pollseed.tools.helper.interfaces;

/**
 * {@link AnnotationController#annotationExecuter(Class, ExecuterHelper)}
 * 実行時の処理を分岐させたい場合にこちらにルールを追加してください.<br>
 */
@FunctionalInterface
public interface AnnotationExecuterHelper {

    /**
     * {@link ProcessTimer}
     *
     */
    void processTimerExecute();

}
