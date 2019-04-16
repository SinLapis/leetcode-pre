import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;
    int value;

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return x == ((Point) obj).x && y == ((Point) obj).y;
        } catch (ClassCastException e) {
            return false;
        }
    }
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        int width = matrix.length;
        int height = matrix[0].length;
        int[][] distance = new int[width][height];

        // 找所有0，初始化distance每个值
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Point(i, j, 0));
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = width + height;
                }
            }
        }

        Point next;
        while (!queue.isEmpty()) {
            next = queue.poll();
            // 更新周围值为当前最小
            if (
                    next.x + 1 < width &&
                            matrix[next.x + 1][next.y] == 1 &&
                            distance[next.x + 1][next.y] > next.value + 1
            ) {
                distance[next.x + 1][next.y] = next.value + 1;
                queue.add(new Point(next.x + 1, next.y, next.value + 1));
            }
            if (
                    next.x - 1 >= 0 &&
                            matrix[next.x - 1][next.y] == 1 &&
                            distance[next.x - 1][next.y] > next.value + 1
            ) {
                distance[next.x - 1][next.y] = next.value + 1;
                queue.add(new Point(next.x - 1, next.y, next.value + 1));
            }
            if (
                    next.y + 1 < height &&
                            matrix[next.x][next.y + 1] == 1 &&
                            distance[next.x][next.y + 1] > next.value + 1
            ) {
                distance[next.x][next.y + 1] = next.value + 1;
                queue.add(new Point(next.x, next.y + 1, next.value + 1));
            }
            if (
                    next.y - 1 >= 0 &&
                            matrix[next.x][next.y - 1] == 1 &&
                            distance[next.x][next.y - 1] > next.value + 1
            ) {
                distance[next.x][next.y - 1] = next.value + 1;
                queue.add(new Point(next.x, next.y - 1, next.value + 1));
            }
        }
        return distance;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
