package pollseed.gof.state;

import pollseed.gof.state.interfaces.Logger;

public class ServerLogger implements Logger {

    @Override
    public String info() {
        return "server info >";
    }

    @Override
    public String warn() {
        return "server warn >";
    }

    @Override
    public String error() {
        return "server error >";
    }

}
