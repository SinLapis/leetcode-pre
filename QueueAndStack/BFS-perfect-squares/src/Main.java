import javax.naming.NoInitialContextException;
import java.util.ArrayList;
import java.util.List;

class Node {
    private int step;
    private int square;
    private int remain;
    Node(int step, int square, int remain) {
        this.square = square;
        this.step = step;
        this.remain = remain;
    }

    public int getRemain() {
        return remain;
    }
    public int getStep() {
        return step;
    }
    public int getSquare() {
        return square;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return this.remain == ((Node) obj).remain && this.step <= ((Node) obj).step;
        } catch (ClassCastException cce) {
            return super.equals(obj);
        }
    }
}
class Solution {
    public int findMaxSquare(int limit) {
        return (int) Math.floor(Math.sqrt(limit));
    }

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        // 0. init
        Node next = new Node(0, 0, n);
        List<Node> oneSteps = new ArrayList<>();
        oneSteps.add(next);
        while (true) {
            next = oneSteps.get(0);
            oneSteps.remove(0);
            // 1. find the max square limited by n
            int max = findMaxSquare(next.getRemain());
            for (int i = 1; i <= max; i++) {
                // 2. add/drop new square or return the step
                // drop
                if (i * i > next.getRemain())
                    break;
                // return
                if (i * i == next.getRemain()) {
                    return next.getStep() + 1;
                }
                // add
                Node temp = new Node(next.getStep() + 1, i * i, next.getRemain() - (i * i));
                if (!oneSteps.contains(temp)) {
                    oneSteps.add(temp);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution s = new Solution();
        System.out.println(s.numSquares(7168));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
