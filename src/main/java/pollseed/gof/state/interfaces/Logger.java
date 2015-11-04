package pollseed.gof.state.interfaces;

/**
 * ログ出力のためのインタフェース.
 */
public interface Logger {
    String info();

    String warn();

    String error();
}
