public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{3, 1}, 1));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int rotate = nums[0];
        if (rotate == target) {
            return 0;
        }
        int mid, left = 0, right = nums.length - 1;
        if (rotate < target) {
            if (left == right) {
                    if (nums[left] == target) return left;
                    else return -1;
                }
                if (left == right - 1) {
                    if (nums[left] == target) return left;
                    else if (nums[right] == target) return right;
                    else return -1;
                }
            while (left <= right) {
                mid = (left + right) >> 1;
                if (nums[mid] == target) return mid;
                if (nums[mid] < rotate || nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        } else {
            while (true) {
                if (left == right) {
                    if (nums[left] == target) return left;
                    else return -1;
                }
                if (left == right - 1) {
                    if (nums[left] == target) return left;
                    else if (nums[right] == target) return right;
                    else return -1;
                }
                mid = (left + right) >> 1;
                if (nums[mid] == target) return mid;
                if (nums[mid] > rotate || nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
    }
}
