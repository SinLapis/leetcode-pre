public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1,2,3,1}));
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) {
            return 0;
        }
        int left = 0, right = nums.length - 1, mid;
        if (nums[right] > nums[right - 1]) {
            return right - 1;
        }
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid - 1] >= nums[mid]) {
                right = mid;
            } else if (nums[mid + 1] <= nums[mid]) {
                right = mid;
                break;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
