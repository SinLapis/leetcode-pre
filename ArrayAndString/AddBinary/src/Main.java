class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        char[] as = a.toCharArray();
        char[] bs = new char[as.length];
        int i;
        for (i = 0; i < a.length() - b.length(); i++) {
            bs[i] = '0';
        }
        b.getChars(0, b.length(), bs, i);
        int point = as.length - 1;
        StringBuilder resultSB = new StringBuilder();
        boolean carry = false;
        while (point >= 0) {
            if (carry) {
                if (as[point] == bs[point]) {
                    resultSB.insert(0, '1');
                    if (as[point] == '0') {
                        carry = false;
                    }
                } else {
                    resultSB.insert(0, '0');
                }
            } else {
                if (as[point] == bs[point]) {
                    resultSB.insert(0, '0');
                    if (as[point] == '1') {
                        carry = true;
                    }
                } else {
                    resultSB.insert(0, '1');
                }
            }
            point--;
        }
        if (carry) {
            resultSB.insert(0, '1');
        }
        return resultSB.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.addBinary("11", "111");
    }
}