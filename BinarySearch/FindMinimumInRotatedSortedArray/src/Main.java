public class Main {
}
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] < nums[1]? nums[0] : nums[1];
        int left = 0, right = nums.length - 1, rotate = nums[0], mid;
        if (rotate < nums[right]) return rotate;
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid + 1] < nums[mid]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] < rotate) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }
}
