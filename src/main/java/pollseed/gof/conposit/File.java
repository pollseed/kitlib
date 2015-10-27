package pollseed.gof.conposit;

import pollseed.gof.conposit.abst.Root;

public class File extends Root {
    private final String name;

    public File(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
