public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0, k = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            } else {
                zeroCount++;
            }
        }
        for (int j = 1; j <= zeroCount; j++) {
            nums[nums.length - j] = 0;
        }
    }
}
