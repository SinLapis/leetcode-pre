import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        if (bottom < 0) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> traverse = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // 上侧左至右
            for (int i = left; i <= right; i++) {
                traverse.add(matrix[top][i]);
            }
            // 剩余单行
            if (top == bottom) {
                break;
            }
            // 右侧上至下
            for (int i = top + 1; i <= bottom; i++) {
                traverse.add(matrix[i][right]);
            }
            // 剩余单列
            if (left == right) {
                break;
            }
            // 下侧右至左
            for (int i = right - 1; i >= left; i--) {
                traverse.add(matrix[bottom][i]);
            }
            // 左侧下至上
            for (int i = bottom - 1; i >= top + 1; i--) {
                traverse.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return traverse;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.spiralOrder(new int[][]{{1,2,3,4,5,6,7,8,9,10}, {11,12,13,14,15,16,17,18,19,20}});
    }
}
