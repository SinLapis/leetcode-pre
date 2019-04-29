import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.firstUniqChar("dddccbba");
    }
}

class Solution {
    public int firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        LinkedHashMap<Character, Integer> cl = new LinkedHashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (cl.containsKey(ss[i])) {
                count.put(ss[i], count.get(ss[i]) + 1);
            } else {
                cl.put(ss[i], i);
                count.put(ss[i], 1);
            }
        }
        for (char c: cl.keySet()) {
            if (count.get(c) == 1) {
                return cl.get(c);
            }
        }
        return -1;
    }
}
