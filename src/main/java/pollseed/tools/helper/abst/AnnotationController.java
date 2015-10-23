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
    protected static int __repeatNumber = 0;
    protected final static Logger LOGGER;
    static {
        LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        LOGGER.addHandler(new StreamHandler() {
            {
                setOutputStream(System.out);
            }
        });
        LOGGER.setUseParentHandlers(false);
        LOGGER.setLevel(Level.INFO);
    }

    @Override
    public final <T> void execute(final AnnotationGenerator actionGenerator, final Class<T> clazz) throws Exception {
        try {
            beforeAnnotationExecute(clazz);
            actionGenerator.generate();
        } catch (Exception e) {
            errorAnnotationExecute(clazz, e);
        } finally {
            afterAnnotationExecute(clazz);
        }
    }

    /**
     * {@link #execute(AnnotationGenerator, Class)} が呼ばれる直前に実行される処理となります.<br>
     * ※コールバックの扱いにならないように実装して下さい.
     *
     * @param clazz
     *            継承元のクラス
     */
    private <T> void beforeAnnotationExecute(final Class<T> clazz) {
        beforeAnnotationExecuter(clazz, new AnnotationExecuterHelperWrapper() {
            @Override
            public void processTimerExecute() {
                LOGGER.info("before");
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
        afterAnnotationExecuter(clazz, new AnnotationExecuterHelperWrapper() {
            @Override
            public void processTimerExecute() {
                LOGGER.info(Long.toString(System.currentTimeMillis() - __result));
                LOGGER.info("after");
            }
        });
    }

    /**
     * {@link #execute(AnnotationGenerator, Class)} が呼ばれ、例外発生時に実行される処理となります.<br>
     * ※コールバックの扱いにならないように実装して下さい.
     *
     * @param clazz
     *            継承元のクラス
     * @param e
     *            例外クラス
     * @throws Exception
     *             例外発生時
     */
    private <T> void errorAnnotationExecute(final Class<T> clazz, final Exception e) throws Exception {
        errorAnnotationExecuter(clazz, new AnnotationExecuterHelperWrapper() {
        }, e);
    }

    /**
     * 処理前に {@code Annotation} の実装を実行する役割を持ちます.
     *
     * @param clazz
     *            継承元のクラス
     * @param executerHelper
     *            {@link AnnotationExecuterHelperWrapper} 固有の処理を実装して下さい
     */
    private <T> void beforeAnnotationExecuter(
            final Class<T> clazz,
            final AnnotationExecuterHelperWrapper executerHelper) {
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (Type.MEASURE == type) {
                            executerHelper.processTimerExecute();
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * 処理後に {@code Annotation} の実装を実行する役割を持ちます.
     *
     * @param clazz
     *            継承元のクラス
     * @param executerHelper
     *            {@link AnnotationExecuterHelperWrapper} 固有の処理を実装して下さい
     */
    private <T> void afterAnnotationExecuter(
            final Class<T> clazz,
            final AnnotationExecuterHelperWrapper executerHelper) {
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (Type.MEASURE == type) {
                            executerHelper.processTimerExecute();
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * エラー時に {@code Annotation} の実装を実行する役割を持ちます.
     *
     * @param clazz
     *            継承元のクラス
     * @param executerHelper
     *            {@link AnnotationExecuterHelperWrapper} 固有の処理を実装して下さい
     * @throws Exception
     *             例外発生時
     */
    private <T> void errorAnnotationExecuter(
            final Class<T> clazz,
            final AnnotationExecuterHelperWrapper executerHelper, final Exception e) throws Exception {
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (e instanceof SilentException) {
                    LOGGER.info(e.getMessage());
                    return;
                } else if (e instanceof SavageException) {
                    throw e;
                }
                // TODO
            }
        }
    }
}
