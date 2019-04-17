class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 左侧和
            int leftSum = 0;
            for (int l = 0; l < i; l++) {
                leftSum += nums[l];
            }
            // 右侧和
            int rightSum = 0;
            for (int r = i + 1; r < nums.length; r++) {
                rightSum += nums[r];
            }
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
}
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
