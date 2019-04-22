class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 1;
        int sum = nums[0];
        int minLen = nums.length + 1;
        int tempLen;
        while (left < nums.length) {
            if (sum < s) {
                if (right < nums.length) {
                    sum += nums[right];
                    right++;
                } else {
                    sum -= nums[left];
                    left++;
                }
            } else {
                tempLen = right - left;
                if (tempLen < minLen) {
                    minLen = tempLen;
                }
                sum -= nums[left];
                left++;
            }
        }
        return minLen < nums.length + 1 ? minLen : 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(3, new int[]{1, 1}));
    }
}
