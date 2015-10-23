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
    public final <T> void execute(final AnnotationGenerator actionGenerator, final Class<T> clazz) throws Exception {
        beforeAnnotationExecute(clazz);
        actionGenerator.generate();
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
        annotationExecuter(clazz, new ExexuterHelper() {
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
        annotationExecuter(clazz, new ExexuterHelper() {
            @Override
            public void measureExecute() {
                __logger.info(Long.toString(System.currentTimeMillis() - __result));
                __logger.info("after");
            }
        });
    }

    /**
     * {@code Annotation} の実装を実行する役割を持ちます.
     *
     * @param clazz
     *            継承元のクラス
     * @param executerHelper
     *            {@link ExexuterHelper} 固有の処理を実装して下さい
     */
    private <T> void annotationExecuter(final Class<T> clazz, final ExexuterHelper executerHelper) {
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

    /**
     * {@link AnnotationController#annotationExecuter(Class, ExexuterHelper)}
     * 実行時の処理を分岐させたい場合にこちらにルールを追加してください.
     *
     */
    private interface ExexuterHelper {

        /**
         * {@link ProcessTimer}
         */
        void measureExecute();
    }
}
