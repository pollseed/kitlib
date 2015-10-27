package pollseed.gof.conposit.abst;

public abstract class Root {
    public void addDirectory(final Root directory) {
    }

    public abstract String getName();

    public abstract int getSize();
}
