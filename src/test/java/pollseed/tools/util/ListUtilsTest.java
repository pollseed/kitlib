package pollseed.tools.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ListUtilsTest {

    @Test
    public void test_join() {
        List<String> a = new ArrayList<String>();
        a.add("hogehoge");
        a.add("");
        a.add("fugafuga");
        List<String> b = new ArrayList<String>();
        b.add("hogehoge1");
        b.add("fugafuga1");
        b.add(null);
        List<String> join = ListUtils.join(a, b, true);
        for (String c : join) {
            System.out.println(c);
        }
    }

    @Test
    public void test_convertMap() {
        List<String> list = new ArrayList<String>();
        list.add("hogehoge");
        list.add("");
        list.add("fugafuga");
        list.add("hogehoge1");
        list.add("fugafuga1");
        String[] keys = new String[] { "test", "aiueo", "fuga", "hoge", "piyo" };
        Map<String, String> convertMap = ListUtils.convertMap(keys, list);
        Iterator<String> iterator = convertMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(convertMap.get(iterator.next()));
        }
    }
}
