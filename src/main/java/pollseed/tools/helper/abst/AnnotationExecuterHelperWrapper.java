package pollseed.tools.helper.abst;

import pollseed.tools.helper.interfaces.AnnotationExecuterHelper;

/**
 * {@link AnnotationExecuterHelper} のラッパークラスとなります.<br>
 * {@link AnnotationExecuterHelper}を実装せず、このクラスを使用して下さい.<br>
 */
@SuppressWarnings("deprecation")
public abstract class AnnotationExecuterHelperWrapper implements AnnotationExecuterHelper {
    @Override
    public void processTimerExecute() {
    }
}
