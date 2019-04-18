class Solution {
    boolean compare(char[] rs, char[] rt, int rsi, int rti) {
        if (rs[rsi] == rt[rti]) {
            if (rt.length <= rti + 1) {
                return true;
            } else {
                return compare(rs, rt, rsi + 1, rti + 1);
            }
        } else {
            return false;
        }
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        int total = hs.length - ns.length + 1;
        for (int i = 0; i < total; i++) {
            if (compare(hs, ns, i, 0)) {
                return i;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}