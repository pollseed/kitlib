package pollseed.gof.bridge;

import pollseed.gof.bridge.abst.AbstractBridge;

public class BridgeImplA extends AbstractBridge {
    @Override
    public String execute() {
        return "execute BridgeImplA";
    }
}
