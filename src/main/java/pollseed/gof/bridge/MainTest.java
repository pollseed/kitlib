package src.main;

// 既存では、Compartmentを実装していたが、その間に処理をはさみたいとき
public class MainTest extends LoggerWrapper {
    @Override
    public void execute() {
        info("main test start");
    }
}
