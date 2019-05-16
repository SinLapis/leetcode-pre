import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int[] param = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            param[i] = r.nextInt();
        }
        Solution2 s2 = new Solution2();
        long startTime = System.currentTimeMillis();   //获取开始时间
        for (int p : param) {
            Math.sqrt((double)p);
        }
        System.out.println();
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        Solution s = new Solution();
        startTime = System.currentTimeMillis();   //获取开始时间
        for (int p : param) {
            s.mySqrt(p);
        }
        System.out.println();
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}

class Solution {
    public int mySqrt(int x) {
        int a = 0, r = 0, t;
        for (int i = 0; i < 16; i++) {
            a <<= 1;
            r = (r << 2) + (x >> 30);
            x <<= 2;
            t = a << 1 + 1;
            if (t <= r) {
                r -= t;
                a++;
            }
        }
        return a;
    }
}

class Solution2 {
    public int mySqrt(int x) {
        int l = 1, b = x, t;
        while (true) {
            if (b - l <= 1) return l;
            l += (b - l) >> 1;
            b = x / l;
            if (l > b) {
                t = l;
                l = b;
                b = t;
            }
        }
    }
}