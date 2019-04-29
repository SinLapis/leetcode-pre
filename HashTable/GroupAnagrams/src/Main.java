import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[] s = new char[]{'a', 'a'};
        System.out.println(new String.valueOf(s));
    }
}

class Solution {
    boolean compareString(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(ss[i])) {
                mapS.put(ss[i], mapS.get(ss[i]) + 1);
            } else {
                mapS.put(ss[i], 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (mapT.containsKey(ts[i])) {
                mapT.put(ts[i], mapT.get(ts[i]) + 1);
            } else {
                mapT.put(ts[i], 1);
            }
        }
        for (Character c : mapS.keySet()) {
            if (!mapS.get(c).equals(mapT.get(c))) {
                return false;
            }
        }
        return true;
    }
    String sortChar(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i - 1; j++) {
                if (ss[j] > ss[j + 1]) {
                    char temp = ss[j];
                    ss[j] = ss[j + 1];
                    ss[j + 1] = temp;
                }
            }
        }
        return String.valueOf(ss);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> classification = new HashMap<>();
        Outer:
        for (String str : strs) {
            for (String key : classification.keySet()) {
                if (compareString(key, str)) {
                    classification.get(key).add(str);
                    continue Outer;
                }
            }
            classification.put(str, new ArrayList<>());
            classification.get(str).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key: classification.keySet()) {
            result.add(classification.get(key));
        }
        return result;
    }
}
