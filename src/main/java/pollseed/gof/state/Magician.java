package src.main.state;

/**
 * 魔術師ジョブクラス.
 */
public class Magician implements JobState {

    @Override
    public String attack() {
        return "ファイア";
    }

    @Override
    public String deathblow() {
        return "灼熱の炎";
    }

}
