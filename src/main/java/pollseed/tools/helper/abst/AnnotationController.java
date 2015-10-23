package pollseed.tools.helper.abst;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import pollseed.tools.helper.interfaces.AnnotationAction;
import pollseed.tools.helper.interfaces.AnnotationAction.ProcessTimer.Type;

/**
 * {@code Annotation} 機能を呼び起こす抽象コントローラクラス.
 */
public abstract class AnnotationController implements AnnotationAction {

    // FIXME refactoring => configファイルとして切り出す等
    private static long __result = 0L;
    protected static Logger __logger;
    static {
        __logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        __logger.addHandler(new StreamHandler() {
            {
                setOutputStream(System.out);
            }
        });
        __logger.setUseParentHandlers(false);
        __logger.setLevel(Level.INFO);
    }

    @Override
    public final <T> void execute(final AnnotationGenerator actionGenerator, final Class<T> clazz) {
        beforeAnnotationExecute(clazz);
        try {
            actionGenerator.generate();
        } catch (Exception e) {
            errorAnnotationExecute(clazz);
        }
        afterAnnotationExecute(clazz);
    }

    /**
     * {@link #execute(AnnotationGenerator, Class)} が呼ばれる直前に実行される処理となります.<br>
     * ※コールバックの扱いにならないように実装して下さい.
     *
     * @param clazz
     *            継承元のクラス
     */
    private <T> void beforeAnnotationExecute(final Class<T> clazz) {
        annotationExecuter(clazz, new AnnotationExecuterHelperWrapper() {
            @Override
            public void measureExecute() {
                __logger.info("before");
                __result = System.currentTimeMillis();
            }
        });
    }

    /**
     * {@link #execute(AnnotationGenerator, Class)} が呼ばれた直後に実行される処理となります.<br>
     * ※コールバックの扱いにならないように実装して下さい.
     *
     * @param clazz
     *            継承元のクラス
     */
    private <T> void afterAnnotationExecute(final Class<T> clazz) {
        annotationExecuter(clazz, new AnnotationExecuterHelperWrapper() {
            @Override
            public void measureExecute() {
                __logger.info(Long.toString(System.currentTimeMillis() - __result));
                __logger.info("after");
            }
        });
    }

    /**
     * {@link #execute(AnnotationGenerator, Class)} が呼ばれ、例外発生時に実行される処理となります.<br>
     * ※コールバックの扱いにならないように実装して下さい.
     *
     * @param clazz
     *            継承元のクラス
     */
    private <T> void errorAnnotationExecute(final Class<T> clazz) {
        annotationExecuter(clazz, new AnnotationExecuterHelperWrapper() {
        });
    }

    /**
     * {@code Annotation} の実装を実行する役割を持ちます.
     *
     * @param clazz
     *            継承元のクラス
     * @param executerHelper
     *            {@link AnnotationExecuterHelperWrapper} 固有の処理を実装して下さい
     */
    private <T> void annotationExecuter(
            final Class<T> clazz,
            final AnnotationExecuterHelperWrapper executerHelper) {
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {

                /**
                 * ************************************ <br>
                 * 全ての {@code Annotation} 処理をここで実装して下さい <br>
                 * ************************************
                 */

                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (Type.MEASURE == type) {
                            executerHelper.measureExecute();
                            return;
                        }
                    }
                }

            }
        }
    }
}
