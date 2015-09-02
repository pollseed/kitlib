package main.common;

/**
 * 処理をするためのインタフェース.
 */
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
    interface RunnerMain {

        /**
         * メイン処理をします.
         */
        void run();
    }
}
