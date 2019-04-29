public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{1, 2, 3, 2, 1}));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
