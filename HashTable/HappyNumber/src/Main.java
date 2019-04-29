import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
}

class Solution {
    int singleSquare(int n) {
        List<Integer> l = new ArrayList<>();
        while (n > 0) {
            l.add(n % 10);
            n /= 10;
        }
        int sum = 0;
        for (int i : l) {
            sum += i * i;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> step = new HashSet<>();
        step.add(n);
        int midResult = n;
        while (true) {
            midResult = singleSquare(midResult);
            if (midResult == 1) {
                return true;
            } else if (step.contains(midResult)) {
                return false;
            } else {
                step.add(midResult);
            }
        }
    }
}