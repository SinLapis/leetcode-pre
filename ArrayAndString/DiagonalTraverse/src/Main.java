class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int width = matrix.length;
        if (width == 0) {
            return new int[]{};
        }
        int height = matrix[0].length;
        boolean reverse = true;
        int c = 0;
        int[] traverse = new int[width * height];
        for (int s = 0; s < width + height - 1; s++) {
            for (int i = 0, j = s; i <= s; i++, j--) {
                if (reverse) {
                    if (i < height && j < width) {
                        traverse[c] = matrix[j][i];
                        c++;
                    }
                } else {
                    if (i < width && j < height) {
                        traverse[c] = matrix[i][j];
                        c++;
                    }
                }
            }
            reverse = !reverse;
        }
        return traverse;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
