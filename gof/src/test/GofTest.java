package src.test;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import src.main.abst.Root;
import src.main.conposit.Directory;
import src.main.conposit.File;

public class GofTest extends AbstractMain {

    @Test
    public void test_composit_pattern() {
        final Directory directory = new Directory(
                Collections.unmodifiableCollection(new ArrayList<Root>() {
                    {
                        add(new File("hoge"));
                        add(new File("hoge1"));
                        add(new File("hoge2"));
                        add(new File("hoge3"));
                        add(new File("hoge4"));
                    }
                }));
        eq(directory.getName(), "hoge:hoge1:hoge2:hoge3:hoge4");
        eq(directory.getSize(), 5);
    }
}
