import java.util.Arrays;

class Solution {
    void moveOnce(int[] nums) {
        int i = nums.length - 1;
        int temp = nums[i];
        for (; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k % nums.length <= 0) {
            return;
        }
        int move = k % nums.length;
        for (int i = 0; i < move; i++) {
            moveOnce(nums);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] l = new int[]{1, 2, 3};
        s.rotate(l, 2);
        System.out.println(Arrays.toString(l));
    }
}
