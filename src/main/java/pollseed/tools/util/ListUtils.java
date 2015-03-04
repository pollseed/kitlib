package pollseed.tools.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListUtils {

  public static <TYPE> List<TYPE> join(List<TYPE> listA, List<TYPE> listB, boolean isRmNull) {
      if (listA == null || listA.isEmpty() || listB == null || listB.isEmpty()) {
          return listA;
      }
      List<TYPE> result = new ArrayList<TYPE>();
      result.addAll(listA);
      result.addAll(listB);
      if (isRmNull) {
          rmNull(result);
      }
      return result;
  }

  public static <TYPE> void rmNull(List<TYPE> list) {
      if (list == null || list.isEmpty()) {
          return;
      }
      list.removeAll(Collections.singleton(null));
  }

  public static <KEY, TYPE> Map<KEY, TYPE> convertMap(KEY[] keys, List<TYPE> list) {
      if (ArrayUtils.isEmpty(keys) || list == null || list.isEmpty() || list.size() != keys.length) {
          return null;
      }
      int i = 0;
      Map<KEY, TYPE> result = new HashMap<KEY, TYPE>();
      for (TYPE value : list) {
          if (keys[i] == null || value == null) {
              continue;
          }
          result.put(keys[i], value);
          i++;
      }
      return result;
  }

  public static void hoge() {

  }

  private ListUtils() {}
  
  // test code
  public static void main(String[] args) {
    List<String> a = new ArrayList<String>();
    a.add("hogehoge");
    a.add("");
    a.add("fugafuga");
    List<String> b = new ArrayList<String>();
    b.add("hogehoge1");
    b.add("fugafuga1");
    b.add(null);
    List<String> join = join(a, b, true);

    for (String c : join) {
        System.out.println(c);
    }
    System.out.println("---------------");
    String[] keys = new String[] { "test", "aiueo", "fuga", "hoge", "piyo" };
    Map<String, String> convertMap = convertMap(keys, join);
    Iterator<String> iterator = convertMap.keySet().iterator();
    while (iterator.hasNext()) {
        System.out.println(convertMap.get(iterator.next()));
    }
  }
}
