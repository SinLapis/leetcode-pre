public class Main {
}
class Solution {
    int find(int[] nums, int end) {
        if (end + 1 == 1) return nums[0];
        if (end + 1 == 2) return nums[0] < nums[1]? nums[0] : nums[1];
        if (nums[end] == nums[0]) return find(nums, end - 1);
        int left = 0, right = end, rotate = nums[0], mid;
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
    public int findMin(int[] nums) {
        return find(nums, nums.length - 1);
    }
}
