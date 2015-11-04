package src.main.state;

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
