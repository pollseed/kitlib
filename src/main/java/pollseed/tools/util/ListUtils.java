package pollseed.tools.util;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

/**
 * List Utils.
 * 
 * @author pollseed
 *
 */
public class ListUtils {

    /**
     * Returns by connecting the list each other specified.
     * 
     * @param <TYPE>
     *            TYPE
     * @param isRmNull
     *            Whether omit the null.
     * @param listA
     *            {@code List<TYPE>}
     * @param listB
     *            {@code List<TYPE>}
     * @return {@code List<TYPE>}
     */
    public static <TYPE> List<TYPE> join(boolean isRmNull, List<TYPE> listA, List<TYPE> listB) {
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

    /**
     * Returns by connecting the lists each other specified.
     * 
     * @param <TYPE>
     *            TYPE
     * @param isRmNull
     *            Whether omit the null.
     * @param listA
     *            {@code List<TYPE>}
     * @param lists
     *            {@code List<TYPE>...}
     * @return {@code List<TYPE>}
     */
    @SafeVarargs
    public static <TYPE> List<TYPE> join(boolean isRmNull, List<TYPE> listA, List<TYPE>... lists) {
        if (listA == null || listA.isEmpty() || lists == null || lists.length == 0) {
            return listA;
        }
        List<TYPE> result = new ArrayList<TYPE>();
        for (List<TYPE> list : lists) {
            if (list == null || list.isEmpty()) {
                continue;
            }
            result.addAll(list);
        }
        return join(isRmNull, listA, result);
    }

    /**
     * Omit the null of the specified list.
     * 
     * @param <TYPE>
     *            TYPE
     * @param list
     *            {@code List<TYPE>}
     */
    public static <TYPE> void rmNull(List<TYPE> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.removeAll(Collections.singleton(null));
    }

    /**
     * Remove the specified element from the specified list.
     * 
     * @param <TYPE>
     *            TYPE
     * @param element
     *            TYPE
     * @param lists
     *            {@code List<TYPE>...}
     * @return {@code List<List<TYPE>>}
     */
    @SafeVarargs
    public static <TYPE> List<List<TYPE>> removeAll(TYPE element, List<TYPE>... lists) {
        if (element == null || lists == null || lists.length == 0) {
            return null;
        }
        List<List<TYPE>> result = new ArrayList<List<TYPE>>();
        for (List<TYPE> list : lists) {
            result.add(list.stream().filter(e -> !e.equals(element)).collect(Collectors.toList()));
        }
        return result;
    }

    /**
     * Based on the specified key, and then mapped the list.
     * 
     * @param <KEY>
     *            KEY
     * @param <TYPE>
     *            TYPE
     * @param keys
     *            KEY[]
     * @param list
     *            {@code List<TYPE>}
     * @return {@code Map<KEY, TYPE>}
     */
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

    /**
     * 指定したリストを指定したロケーションの規則に沿ってソート処理をします.
     * 
     * @param list
     *            ソートしたいリスト
     * @param locale
     *            任意のロケーション
     * @return ソート済みリスト
     */
    public static <TYPE> List<TYPE> sort(List<TYPE> list, Locale locale) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        Collections.sort(list, Collator.getInstance(locale == null ? Locale.getDefault() : locale));
        return list;
    }

}
