import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int k1: map1.keySet()) {
            if (map2.containsKey(k1)) {
                for (int i = 0; i < map1.get(k1) && i < map2.get(k1); i++) {
                    resultList.add(k1);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
