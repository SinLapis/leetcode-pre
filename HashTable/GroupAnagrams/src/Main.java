
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3};
        int[] a2 = new int[]{1, 2, 3};
        System.out.println(Arrays.hashCode(a1));
        System.out.println(Arrays.hashCode(a2));
    }
}

class Solution1 {
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
class Solution {
    int hashArray(String s) {
        int[] alpha = new int[26];
        for (char c: s.toCharArray()) {
            alpha[c - 'a']++;
        }
        return Arrays.hashCode(alpha);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> strCount = new HashMap<>();
        for (String s: strs) {
            int newKey = hashArray(s);
            List<String> l = strCount.getOrDefault(newKey, new ArrayList<>());
            l.add(s);
            strCount.put(newKey, l);
        }
        return new ArrayList<>(strCount.values());
    }
}