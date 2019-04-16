import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        queue.add(new int[]{sr, sc});
        int[] next;
        int width = image.length;
        int height = image[0].length;
        while (!queue.isEmpty()) {
            next = queue.poll();
            // 修改颜色
            image[next[0]][next[1]] = newColor;
            // 周边入队
            if (next[0] + 1 < width && image[next[0] + 1][next[1]] == oldColor) {
                queue.add(new int[]{next[0] + 1, next[1]});
            }
            if (next[0] - 1 >= 0 && image[next[0] - 1][next[1]] == oldColor) {
                queue.add(new int[]{next[0] - 1, next[1]});
            }
            if (next[1] + 1 < height && image[next[0]][next[1] + 1] == oldColor) {
                queue.add(new int[]{next[0], next[1] + 1});
            }
            if (next[1] - 1 >= 0 && image[next[0]][next[1] - 1] == oldColor) {
                queue.add(new int[]{next[0], next[1] - 1});
            }
        }
        return image;
    }
}

public class Main {

    public static void main(String[] args) {
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.floodFill(image, 1, 1, 1)));
    }
}
