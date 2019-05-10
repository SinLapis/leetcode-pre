import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1, targetIndex = -1, mid, start = -1, end = -1;
        if (nums[0] == nums[right]) {
            if (target == nums[0]) return new int[]{0, right};
            else return new int[]{-1, -1};
        }
        // 找值
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[right] == target) targetIndex = right;
        if (targetIndex == -1) return new int[]{-1, -1};
        // 找start
        left = 0;
        right = targetIndex;
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid] != target) {
                left = mid + 1;
                continue;
            }
            right = mid;
            if (mid == 0 || nums[mid] != nums[mid - 1]) {
                break;
            }
        }
        start = right;
        // 找end
        left = targetIndex;
        right = nums.length - 1;
        while (left < right) {
            mid = left + (right - left >> 1);
            if (nums[mid] != target) {
                right = mid;
                continue;
            }
            if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                left = mid;
                break;
            }
            left = mid + 1;
        }
        end = left;
        return new int[]{start, end};
    }
}
