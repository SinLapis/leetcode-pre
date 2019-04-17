import java.util.Arrays;

class Solution {
    public int dominantIndex(int[] nums) {
        int first = 0, second = 0;
        int firstIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                firstIndex = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        System.out.println(Arrays.toString(new int[]{first, second}));
        if ((second != 0 && second * 2 <= first) || (second == 0 && first != 0)) {
            return firstIndex;
        } else {
            return -1;
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.dominantIndex(new int[]{0,0,2,3});
    }
}
