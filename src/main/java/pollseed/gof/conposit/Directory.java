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
        for (final Root order : collection) {
            addDirectory(order);
        }
    }

    private final List<Root> directories = new ArrayList<Root>();

    @Override
    public void addDirectory(final Root order) {
        directories.add(order);
    }

    @Override
    public String getName() {
        final StringBuilder result = new StringBuilder();
        int i = 0;
        for (final Root directory : directories) {
            if (i != 0) {
                result.append(":");
            }
            result.append(directory.getName());
            i++;
        }
        return result.toString();
    }

    @Override
    public int getSize() {
        return directories.size();
    }
}
