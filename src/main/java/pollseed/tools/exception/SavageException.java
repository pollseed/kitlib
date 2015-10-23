package pollseed.tools.exception;

/**
 * どの処理であろうと必ず {@code throw} して下さい.<br>
 * <b>※例外を噛み潰さないで下さい.</b>
 */
public class SavageException extends Exception {
    public SavageException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public SavageException(final String msg) {
        super(msg);
    }
}
