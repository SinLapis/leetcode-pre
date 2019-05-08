import java.util.HashMap;

public class Main {
}

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int sum;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = 0 - A[i] - B[j];
                sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum = C[i] + D[j];
                result += sums.getOrDefault(sum, 0);
            }
        }
        return result;
    }
}