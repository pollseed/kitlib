package src.main.state;

public class LoggerImpl implements Logger {
    private Logger logger;

    public LoggerImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String info() {
        return logger.info();
    }

    @Override
    public String warn() {
        return logger.warn();
    }

    @Override
    public String error() {
        return logger.error();
    }

}
