package pollseed.tools.helper.interfaces;

/**
 * 処理をするためのインタフェース.
 */
@FunctionalInterface
public interface Runner {

    /**
     * 主処理の時間を計測します.
     *
     * @param main
     *            {@link RunnerMain}
     * @return ミリ秒
     */
    long getTimes(RunnerMain main);

    /**
     * メイン処理のインタフェース
     */
    @FunctionalInterface
    interface RunnerMain {

        /**
         * メイン処理をします.
         */
        void run();
    }
}
