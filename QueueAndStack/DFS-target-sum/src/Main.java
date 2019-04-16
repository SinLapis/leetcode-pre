import java.util.Stack;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
//        Stack<Boolean> operatorStack = new Stack<>();
        boolean[] operatorStack1 = new boolean[21];
        int stackPointer = 0;
        int length = nums.length;
        int result = 0;
        outside:
        while (true) {
            // 1 init operator stack
            int sum = 0;
            for (int i = 0; i < length; i++) {
                if (i < stackPointer) {
                    if (operatorStack1[i]) {
                        sum += nums[i];
                    } else {
                        sum -= nums[i];
                    }
                } else {
                    operatorStack1[stackPointer++] = true;
                    sum += nums[i];
                }
            }
            if (S == sum) {
                result++;
            }
            // 2 pop plus push minus
            while (true) {
                // 2.1 stack empty
                if (stackPointer == 0) {
                    break outside;
                }
                // 2.2 pop 1st 1
                if (operatorStack1[stackPointer - 1]) {
                    operatorStack1[stackPointer - 1] = false;
                    break;
                }
                // 2.3 pop 0
                if (!operatorStack1[stackPointer - 1]) {
                    stackPointer--;
                }
            }
        }
        return result;
    }
}

class Solution1 {
    int total = 0;

    void helper(int idx, int nums[], int target, int s) {
        if (idx == nums.length && target == s) {
            total++;
            return;
        }
        if (idx >= nums.length) return;
        helper(idx + 1, nums, target + nums[idx], s);
        helper(idx + 1, nums, target - nums[idx], s);
    }

    public int findTargetSumWays(int[] nums, int S) {
        helper(0, nums, 0, S);
        return total;
    }
}

class Solution2 {
    public int Find(int i, int curSum, int[] nums, int S) {
        if (i >= nums.length)
            return (curSum == S) ? 1 : 0;
        return Find(i + 1, curSum + nums[i], nums, S) + Find(i + 1, curSum - nums[i], nums, S);
    }

    public int findTargetSumWays(int[] nums, int S) {

        return Find(0, 0, nums, S);
    }
}

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();   //获取开始时间
        Solution s = new Solution();
        s.findTargetSumWays(new int[]{10, 9, 6, 4, 19, 0, 41, 30, 27, 15, 14, 39, 33, 7, 34, 17, 24, 46, 2, 46}, 45);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();   //获取开始时间
        Solution1 s1 = new Solution1();
        s1.findTargetSumWays(new int[]{10, 9, 6, 4, 19, 0, 41, 30, 27, 15, 14, 39, 33, 7, 34, 17, 24, 46, 2, 46}, 45);
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();   //获取开始时间
        Solution1 s2 = new Solution1();
        s2.findTargetSumWays(new int[]{10, 9, 6, 4, 19, 0, 41, 30, 27, 15, 14, 39, 33, 7, 34, 17, 24, 46, 2, 46}, 45);
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();   //获取开始时间
        Solution s3 = new Solution();
        s3.findTargetSumWays(new int[]{10, 9, 6, 4, 19, 0, 41, 30, 27, 15, 14, 39, 33, 7, 34, 17, 24, 46, 2, 46}, 45);
        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
