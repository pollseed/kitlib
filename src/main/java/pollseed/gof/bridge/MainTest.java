package pollseed.gof.bridge;

import pollseed.gof.bridge.abst.LoggerWrapper;

// 既存では、Compartmentを実装していたが、その間に処理をはさみたいとき
// ex.) 使う時
// final Compartment c = new MainExecuter(new MainTest());
// c.execute();
public class MainTest extends LoggerWrapper {
    @Override
    public void execute() {
        info("main test start");
    }
}
