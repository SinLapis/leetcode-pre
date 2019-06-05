import java.util.Arrays;

public class Main {
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        while (true) {
            Arrays.sort(stones);
            if (stones[stones.length - 2] == 0) return stones[stones.length - 1];
            stones[stones.length - 1] -= stones[stones.length - 2];
            stones[stones.length - 2] = 0;
        }
    }
}