package pollseed.tools.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

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

        final List<String> baseList = new ArrayList<String>();
        baseList.add("hogehoge");
        baseList.add("");
        baseList.add("fugafuga");
        baseList.add("hogehoge1");
        baseList.add("fugafuga1");

        List<String> join = ListUtils.join(true, a, b);
        Assert.assertTrue(join.size() == baseList.size());
        for (String c : join) {
            Assert.assertTrue(baseList.contains(c));
        }
    }

    @Test
    public void test_joins() {
        List<String> a = new ArrayList<String>();
        a.add("hogehoge");
        a.add("");
        a.add("fugafuga");
        List<String> b = new ArrayList<String>();
        b.add("hogehoge1");
        b.add("fugafuga1");
        b.add(null);
        List<String> c = new ArrayList<String>();
        c.add("hogehoge2");
        c.add("fugafuga2");

        final List<String> baseList = new ArrayList<String>();
        baseList.add("hogehoge");
        baseList.add("");
        baseList.add("fugafuga");
        baseList.add("hogehoge1");
        baseList.add("fugafuga1");
        baseList.add("hogehoge2");
        baseList.add("fugafuga2");

        List<String> join = ListUtils.join(true, a, b, c);
        Assert.assertTrue(join.size() == baseList.size());
        for (String d : join) {
            Assert.assertTrue(baseList.contains(d));
        }
    }

    @Test
    public void test_removeAll() {
        final String _fuga = "fugafuga";
        List<String> list = Arrays.asList("hogehoge", _fuga, "piyopiyo", _fuga);

        List<List<String>> null_element = ListUtils.removeAll(null, list);
        List<List<String>> null_list = ListUtils.removeAll(_fuga, null);
        Assert.assertNull(null_element);
        Assert.assertNull(null_list);

        List<List<String>> result = ListUtils.removeAll(_fuga, list);
        for (List<String> s : result) {
            Assert.assertTrue(s.size() == 2);
            Assert.assertFalse(s.contains(_fuga));
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

        Map<String, String> baseMap = new HashMap<String, String>();
        baseMap.put("test", "hogehoge");
        baseMap.put("aiueo", "");
        baseMap.put("fuga", "fugafuga");
        baseMap.put("hoge", "hogehoge1");
        baseMap.put("piyo", "fugafuga1");

        Map<String, String> convertMap = ListUtils.convertMap(keys, list);
        Assert.assertTrue(baseMap.size() == convertMap.size());
        Iterator<String> iterator = convertMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Assert.assertEquals(baseMap.get(key), convertMap.get(key));
        }
    }
}
