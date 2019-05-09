import java.util.HashMap;

public class Main {
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        HashMap<Character, Integer> jSum = new HashMap<>();
        for (char j: js) {
            jSum.put(j, 0);
        }
        for (char s: ss) {
            if (jSum.containsKey(s)) {
                jSum.put(s, jSum.get(s) + 1);
            }
        }
        int result = 0;
        for (int i: jSum.values()) {
            result += i;
        }
        return result;
    }
}
