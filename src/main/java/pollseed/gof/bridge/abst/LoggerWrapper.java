package pollseed.gof.bridge.abst;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import pollseed.gof.bridge.interfaces.Compartment;

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

    protected void info(final List<Object> objs) {
        if (objs == null || objs.isEmpty())
            return;
        objs.stream().filter(s -> s != null).forEach(v -> {
            LOGGER.info(v.toString());
        });
    }
}
