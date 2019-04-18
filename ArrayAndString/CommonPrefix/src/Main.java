class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[][] css = new char[strs.length][];
        int minStringLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            css[i] = strs[i].toCharArray();
            if (css[i].length < minStringLen) {
                minStringLen = css[i].length;
            }
        }
        StringBuilder commonPrefix = new StringBuilder();
        outer:
        for (int j = 0; j < minStringLen; j++) {
            for (int i = 1; i < css.length; i++) {
                if (css[i][j] != css[0][j]) {
                    break outer;
                }
            }
            commonPrefix.append(css[0][j]);
        }
        return commonPrefix.toString();
    }
}
public class Main {
    public static void main(String[] args) {

    }
}