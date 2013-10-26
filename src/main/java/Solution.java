import java.util.*;

/**
 * Create date: 24-10-2013
 *
 * @author axkostyliev
 */
public class Solution {

    public int solution(int[] A) {
        int result = 0;

        final NavigableMap<Integer, NavigableSet<Integer>> map = new TreeMap<Integer, NavigableSet<Integer>>();
        final NavigableSet<Integer> values = new TreeSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            addItem(map, A[i], i);
            values.add(i);
        }

        for (int key : map.keySet()) {
            final NavigableSet<Integer> value = map.get(key);
            values.removeAll(value);
            for (int val : value) {
                final SortedSet<Integer> tailSet = values.headSet(val);
                result += tailSet.size();
            }
        }

        return result;
    }

    private static <K, V> void addItem(Map<K, NavigableSet<V>> map, K key, V value) {
        final NavigableSet<V> values;
        if (!map.containsKey(key)) {
            values = new TreeSet<V>();
            map.put(key, values);
        } else {
            values = map.get(key);
        }
        values.add(value);
    }
}
