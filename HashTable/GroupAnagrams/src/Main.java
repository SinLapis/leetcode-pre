
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{1, 2, 3};
        Integer[] l2 = new Integer[]{1, 2, 3};
        HashMap<Integer[], Integer> a = new HashMap<>();
        a.put(l1, 1);
        a.put(l2, 2);
        System.out.println(Arrays.hashCode(l1));
        System.out.println(Arrays.hashCode(l2));
    }
}

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> classification = new HashMap<>();
        List<String> keys = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();
        Outer:
        for (String str : strs) {
            char[] mid = str.toCharArray();
            Arrays.sort(mid);
            String newKey = String.valueOf(mid);
            for (int i = 0; i < keys.size(); i++) {
                if (newKey.equals(keys.get(i))) {
                    results.get(i).add(str);
                    continue Outer;
                }
            }
            keys.add(newKey);
            List<String> newResult = new ArrayList<>();
            newResult.add(str);
            results.add(newResult);
        }
        return results;
    }
}