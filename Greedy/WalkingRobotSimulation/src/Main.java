public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{new int[]{2, 4}}));
    }
}

// 874
class Solution {
    void northMove(int step, int[][] obstacles, int[] point) {
        int i;
        for (i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == point[0] && obstacles[i][1] > point[1] && obstacles[i][1] <= point[1] + step) {
                point[1] = obstacles[i][1] - 1;
                break;
            }
        }
        if (i == obstacles.length)
            point[1] += step;
    }

    void southMove(int step, int[][] obstacles, int[] point) {
        int i;
        for (i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] == point[0] && obstacles[i][1] < point[1] && obstacles[i][1] >= point[1] - step) {
                point[1] = obstacles[i][1] + 1;
                break;
            }
        }
        if (i == obstacles.length)
            point[1] -= step;
    }

    void eastMove(int step, int[][] obstacles, int[] point) {
        int i;
        for (i = 0; i < obstacles.length; i++) {
            if (obstacles[i][1] == point[1] && obstacles[i][0] > point[0] && obstacles[i][0] <= point[0] + step) {
                point[0] = obstacles[i][0] - 1;
                break;
            }
        }
        if (i == obstacles.length)
            point[0] += step;
    }

    void westMove(int step, int[][] obstacles, int[] point) {
        int i;
        for (i = 0; i < obstacles.length; i++) {
            if (obstacles[i][1] == point[1] && obstacles[i][0] < point[0] && obstacles[i][0] >= point[0] - step) {
                point[0] = obstacles[i][0] + 1;
                break;
            }
        }
        if (i == obstacles.length)
            point[0] -= step;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands.length == 0) return 0;
        int orient = 0;
        int[] point = new int[]{0, 0};
        int max = 0, temp;
        for (int c : commands) {
            if (c == -1) {
                orient = (orient + 1) % 4;
            } else if (c == -2) {
                orient = (orient + 3) % 4;
            } else {
                switch (orient) {
                    case 0:
                        northMove(c, obstacles, point);
                        break;
                    case 1:
                        eastMove(c, obstacles, point);
                        break;
                    case 2:
                        southMove(c, obstacles, point);
                        break;
                    case 3:
                        westMove(c, obstacles, point);
                }
                temp = point[0] * point[0] + point[1] * point[1];
                if (temp > max) max = temp;
            }
        }
        return max;
    }
}
