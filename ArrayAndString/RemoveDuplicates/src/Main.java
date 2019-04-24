class Solution {
    public int removeDuplicates(int[] nums) {
        int end = nums.length;
        for (int i = 0; i < end; i++) {
            int tempEnd = end;
            for (int j = i + 1, k = i + 1; j < tempEnd; j++) {
                if (nums[j] != nums[i]) {
                    nums[k] = nums[j];
                    k++;
                } else {
                    end--;
                }
            }
        }
        return end;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
