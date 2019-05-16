public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[]{4,3,1,4,2}));
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int mid, left = 1, right = nums.length - 1;
        int larger, smaller, equal;
        while (left < right) {
            mid = left + (right - left >> 1);
            larger = smaller = equal = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > right || nums[i] < left) continue;
                if (nums[i] > mid) larger++;
                else if (nums[i] < mid) smaller++;
                else equal++;
            }
            if (equal > 1) return mid;
            if (larger > smaller) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}