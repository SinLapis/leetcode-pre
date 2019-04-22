class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int i = 0, k = 0;
        do {
            if (k > max) {
                max = k;
            }
            if (nums[i] == 1) {
                k++;
            } else {
                k = 0;
            }
            i++;
        } while (i < nums.length);
        return max > k ? max : k;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
