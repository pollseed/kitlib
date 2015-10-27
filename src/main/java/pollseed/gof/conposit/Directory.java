package pollseed.gof.conposit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pollseed.gof.conposit.abst.Root;

public class Directory extends Root {
    public Directory(final Collection<Root> collection) {
        addDirectory(collection);
    }

    private void addDirectory(final Collection<Root> collection) {
        collection.forEach(c -> addDirectory(c));
    }

    private final List<Root> directories = new ArrayList<Root>();

    @Override
    public void addDirectory(final Root directory) {
        directories.add(directory);
    }

    @Override
    public String getName() {
        final StringBuilder result = new StringBuilder();
        directories.forEach(directory -> {
            if (result.length() != 0) {
                result.append(":");
            }
            result.append(directory.getName());
        });
        return result.toString();
    }

    @Override
    public int getSize() {
        return directories.size();
    }
}
