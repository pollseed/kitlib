package pollseed.tools.exception;

public class SilentException extends Exception {
    public SilentException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public SilentException(final String msg) {
        super(msg);
    }
}
