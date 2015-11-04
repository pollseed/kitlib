package pollseed.gof.state;

import pollseed.gof.state.interfaces.Logger;

public class UserLogger implements Logger {

    @Override
    public String info() {
        return "user info >";
    }

    @Override
    public String warn() {
        return "user warn >";
    }

    @Override
    public String error() {
        return "user error >";
    }

}
