package src.main.state;

/**
 * 職業のコマンドインタフェース.
 */
public interface JobState {
    /**
     * 通常攻撃をする
     */
    String attack();

    /**
     * 必殺技を使う
     */
    String deathblow();
}
