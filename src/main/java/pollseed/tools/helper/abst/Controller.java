package pollseed.tools.helper.abst;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import pollseed.tools.helper.interfaces.Action;
import pollseed.tools.helper.interfaces.Action.PreAction;
import pollseed.tools.helper.interfaces.Action.ProcessTimer.Type;

import static pollseed.tools.helper.interfaces.Action.ProcessTimer.Type.MEASURE;

/**
 * 抽象コントローラクラス
 */
public abstract class Controller implements Action, PreAction {
    private long __result = 0L;

    @Override
    public final <T> void run(final PreAction preAct, final Class<T> clazz) throws Exception {
        before(clazz);
        preAct.generator();
        after(clazz);
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public final <T> void before(final Class<T> clazz) throws Exception {
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (MEASURE == type) {
                            System.out.println("before");
                            __result = System.currentTimeMillis();
                            // method.invoke(type);
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public final <T> void after(final Class<T> clazz) {
        for (final Method method : clazz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (MEASURE == type) {
                            System.out.println("after");
                            System.out.println(System.currentTimeMillis() - __result);
                            // method.invoke(null);
                            return;
                        }
                    }
                }
            }
        }
    }
}
