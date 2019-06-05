import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.monotoneIncreasingDigits(668841));
    }
}
// 738
class Solution {
    public int monotoneIncreasingDigits(int N) {
        List<Integer> ns = new ArrayList<>();
        int origin = N;
        while (origin >= 10) {
            ns.add(0, origin % 10);
            origin /= 10;
        }
        ns.add(0, origin);
        List<Integer> rs = new ArrayList<>();
        int last = ns.get(0), current, up = 0;
        rs.add(last);
        boolean error = false;
        for (int i = 1; i < ns.size(); i++) {
            if (error) {
                rs.add(9);
                continue;
            }
            current = ns.get(i);
            if (current < last) {
                error = true;
                rs.set(up, rs.get(up) - 1);
                for (int j = up + 1;j < i; j++) {
                    rs.set(j, 9);
                }
                rs.add(9);
            } else {
                rs.add(current);
                if (current > last) {
                    up = i;
                }
                last = current;
            }
        }
        int result = 0;
        for (int r : rs) {
            result = result * 10 + r;
        }
        return result;
    }
}
