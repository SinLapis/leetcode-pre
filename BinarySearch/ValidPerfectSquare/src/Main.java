import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(16));
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        long a = 0, r = 0, t, x = num;
        for (int i = 0; i < 16; i++) {
            a <<= 1;
            r = (r << 2) + ((x >> 30) & 3);
            x <<= 2;
            t = (a << 1) + 1;
            if (t <= r) {
                r -= t;
                a++;
            }
        }
        return a * a == num;
    }
}
