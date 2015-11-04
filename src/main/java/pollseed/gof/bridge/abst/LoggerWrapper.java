package src.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public abstract class LoggerWrapper implements Compartment {
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

    protected void info(final Object obj) {
        if (obj == null)
            return;
        LOGGER.info(obj.toString());
    }

    protected void info(final Object... objs) {
        if (objs == null || objs.length == 0)
            return;
        for (Object obj : objs) {
            if (obj == null)
                continue;
            LOGGER.info(obj.toString());
        }
    }
}
