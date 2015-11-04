package src.main.state;

/**
 * 剣士ジョブクラス.
 */
public class SwordsMan implements JobState {
    @Override
    public String attack() {
        return "斬り";
    }

    @Override
    public String deathblow() {
        return "雷鳴斬";
    }

}
