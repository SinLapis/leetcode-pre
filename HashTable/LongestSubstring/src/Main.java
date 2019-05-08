import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("ieblgmgiyhhxygivtwvfzvtgmikwndryisjqeradzhczpmujirqjojpbuzxhdohnjqdpkdulnykekgnszddnpsojsnsxeaknspec"));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> char2Index = new HashMap<>();
        HashMap<Integer, Character> index2Char = new HashMap<>();
        char[] ss = s.toCharArray();
        int maxLen = 0, len = 0;
        for (int i = 0; i < ss.length; i++) {
//            System.out.println(char2Index);
//            System.out.println(index2Char);
//            System.out.println(len);
            int index = char2Index.getOrDefault(ss[i], -1);
            if (index == -1) {
                char2Index.put(ss[i], i);
                index2Char.put(i, ss[i]);
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
            } else if (i == len + index) {
                char2Index.put(ss[i], i);
                index2Char.remove(index);
                index2Char.put(i, ss[i]);
            } else {
                int j = index;
                while (char2Index.remove(index2Char.get(j)) != null) {
                    index2Char.remove(j);
                    j--;
                }
                len = len - index + j + 1;
                char2Index.put(ss[i], i);
                index2Char.put(i, ss[i]);
            }
        }
        return maxLen;
    }
}
