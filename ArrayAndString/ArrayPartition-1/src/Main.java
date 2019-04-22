import java.util.Arrays;

class Solution {
    int[] sort(int[] nums, int start, int end) {
        // 递归部分
        if (end - start == 0) {
            return new int[]{nums[start]};
        } else if (end - start == 1) {
            if (nums[start] < nums[end]) {
                return new int[]{nums[start], nums[end]};
            } else {
                return new int[]{nums[end], nums[start]};
            }
        } else {
            int[] left = sort(nums, start, (start + end) / 2);
            int[] right = sort(nums, (start + end) / 2 + 1, end);
            int leftIndex = 0;
            int rightIndex = 0;
            int[] sorted = new int[left.length + right.length];
            int i = 0;
            while (i < left.length + right.length) {
                if (leftIndex >= left.length && rightIndex < right.length) {
                    sorted[i] = right[rightIndex];
                    rightIndex++;
                } else if (rightIndex >= right.length && leftIndex < left.length) {
                    sorted[i] = left[leftIndex];
                    leftIndex++;
                } else if (left[leftIndex] < right[rightIndex]) {
                    sorted[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    sorted[i] = right[rightIndex];
                    rightIndex++;
                }
                i++;
            }
            return sorted;
        }
    }
    public int arrayPairSum1(int[] nums) {
        int temp;
        boolean flag = true;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (flag) {
                sum += nums[nums.length - i - 1];
            }
            flag = !flag;
        }
        return sum;
    }
    public int arrayPairSum(int[] nums) {
        int[] sorted = sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(sorted));
        int sum = 0;
        for (int i = 0; i < sorted.length; i += 2) {
            sum += sorted[i];
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.arrayPairSum(new int[]{1,2,3,2});
    }
}
