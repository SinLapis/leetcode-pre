public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(new int[]{2, 5}, 0);
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (true) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (start >= end){
                return -1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target){
                end = mid - 1;
            }
        }
    }
}
