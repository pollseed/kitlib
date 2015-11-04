package src.main.state;

/**
 * ログ出力のためのインタフェース.
 */
public interface Logger {
    String info();

    String warn();

    String error();
}
