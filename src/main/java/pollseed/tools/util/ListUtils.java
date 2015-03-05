package pollseed.tools.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param isRmNull
     *            Whether omit the null.
     * @param listA
     *            List<TYPE>
     * @param listB
     *            List<TYPE>
     * @return List<TYPE>
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
     * @param isRmNull
     *            Whether omit the null.
     * @param listA
     *            List<TYPE>
     * @param lists
     *            List<TYPE>...
     * @return List<TYPE>
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
     * @param list
     *            List<TYPE>
     */
    public static <TYPE> void rmNull(List<TYPE> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.removeAll(Collections.singleton(null));
    }

    /**
     * Based on the specified key, and then mapped the list.
     * 
     * @param keys
     *            KEY[]
     * @param list
     *            List<TYPE>
     * @return Map<KEY, TYPE>
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

}
