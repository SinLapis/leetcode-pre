public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int remain;
        for (int i = 0; i < nums.length; i++) {
            remain = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == remain) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}