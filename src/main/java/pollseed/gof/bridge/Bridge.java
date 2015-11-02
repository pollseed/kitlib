package src.main.bridge;

public class Bridge extends AbstractBridge {
    private AbstractBridge abstractBridge;

    public Bridge() {

    }

    public Bridge(AbstractBridge abstractBridge) {
        this.abstractBridge = abstractBridge;
    }

    @Override
    public String execute() {
        return abstractBridge.execute();
    }

    public String executeBridge() {
        return "execute Bridge";
    }
}
