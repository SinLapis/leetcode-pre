import java.util.HashMap;

public class Main {
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> replacement = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (replacement.containsKey(ss[i])) {
                if (ts[i] != replacement.get(ss[i])) {
                    return false;
                }
            } else {
                if (replacement.containsValue(ts[i])) {
                    return false;
                }
                replacement.put(ss[i], ts[i]);
            }
        }
        return true;
    }
}