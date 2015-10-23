package pollseed.tools.exception;

public class SavageException extends Exception {
    public SavageException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public SavageException(final String msg) {
        super(msg);
    }
}
