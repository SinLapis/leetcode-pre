import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(2147395599));
    }
}

class Solution {
    int findNextB(int x, int a) {
        int left = 0, right = 9, b = 5;
        int count, countPlus;
        while (true) {
            count = (2 * a + b) * b;
            countPlus = (2 * a + b + 1) * (b + 1);
            if (count <= x && countPlus > x) {
                return b;
            }
            if (count < x) {
                if (b == 9) {
                    return 9;
                } else {
                    left = b + 1;
                    b = (b + 1 + right) / 2;
                    continue;
                }
            }
            if (count > x) {
                if (b == 0) {
                    return 0;
                } else {
                    right = b - 1;
                    b = (b - 1 + left) / 2;
                }
            }
        }
    }

    int sqrtUnder100(int x) {
        int squareRoot = 5;
        int left = 0, right = 10;
        while (true) {
            if (squareRoot * squareRoot <= x && (squareRoot + 1) * (squareRoot + 1) > x) {
                return squareRoot;
            } else if (squareRoot * squareRoot < x) {
                left = squareRoot + 1;
                squareRoot = (squareRoot + 1 + right) / 2;
            } else {
                right = squareRoot - 1;
                squareRoot = (squareRoot - 1 + left) / 2;
            }
        }
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int len = 0;
        int tempX = x;
        List<Integer> singleNums = new ArrayList<>();
        while (tempX != 0) {
            singleNums.add(tempX % 10);
            tempX /= 10;
            len++;
        }
        int squareRoot = 0;
        int limit;
        int i;
        if (len % 2 == 1) {
            limit = singleNums.get(len - 1);
            i = len - 2;
        } else {
            limit = singleNums.get(len - 1) * 10 + singleNums.get(len - 2);
            i = len - 3;
        }
        // 第一节
        squareRoot = sqrtUnder100(limit);
        limit = limit - squareRoot * squareRoot;
        int nextSingle;
        for (; i >= 0; i -= 2) {
            limit = limit * 100 + singleNums.get(i) * 10 + singleNums.get(i - 1);
            squareRoot *= 10;
            nextSingle = findNextB(limit, squareRoot);
            limit = limit - (2 * squareRoot + nextSingle) * nextSingle;
            squareRoot += nextSingle;
        }
        return squareRoot;
    }
}
