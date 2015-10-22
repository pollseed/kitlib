package main.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import main.controller.Action.PreAction;
import main.controller.Action.ProcessTimer.Type;

/**
 * 抽象コントローラクラス
 */
public abstract class Controller implements Action, PreAction {
    private long __result = 0L;

    @Override
    public final <T> void run(final PreAction preAct, final Class<T> claz) throws Exception {
        before(claz);
        preAct.generator();
        after(claz);
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public final <T> void before(final Class<T> claz) throws Exception {
        for (final Method method : claz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (Type.MEASURE == type) {
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
    public final <T> void after(final Class<T> claz) {
        for (final Method method : claz.getDeclaredMethods()) {
            for (final Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation instanceof ProcessTimer) {
                    for (final Type type : ((ProcessTimer) annotation).value()) {
                        if (Type.MEASURE == type) {
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
