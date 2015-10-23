package pollseed.tools.exception;

/**
 * 例外処理として扱いますが、終端で {@code throw} させないで下さい.<br>
 * <b>※基本的には噛み潰して下さい.</b>
 */
public class SilentException extends Exception {
    private static final long serialVersionUID = 1L;

    public SilentException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public SilentException(final String msg) {
        super(msg);
    }
}
