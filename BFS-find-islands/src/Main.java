import java.util.ArrayList;
import java.util.List;


class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Solution {
    private Coordinate findFirstOne(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    return new Coordinate(i, j);
                }
            }
        }
        return new Coordinate(-1, -1);
    }

    public int numIslands(char[][] grid) {
        List<Coordinate> waitCoordinates = new ArrayList<>();
        int numOfIslands = 0;
        int width = grid.length;
        if (width == 0)
            return 0;
        int height = grid[0].length;
        while (true) {
            // 1. find the 1st '1'
            Coordinate start = findFirstOne(grid);
            if (start.getX() == -1) {
                return numOfIslands;
            }
            // 2. set the start point and find the island beginning with the start point
            waitCoordinates.add(start);
            while (!waitCoordinates.isEmpty()) {
                Coordinate next = waitCoordinates.get(0);
                waitCoordinates.remove(0);
                if (grid[next.getX()][next.getY()] != '1')
                    continue;
                if (next.getX() < width - 1 && grid[next.getX() + 1][next.getY()] == '1') {
                    waitCoordinates.add(new Coordinate(next.getX() + 1, next.getY()));
                }
                if (next.getY() < height - 1 && grid[next.getX()][next.getY() + 1] == '1') {
                    waitCoordinates.add(new Coordinate(next.getX(), next.getY() + 1));
                }
                if (next.getX() > 0 && grid[next.getX() - 1][next.getY()] == '1') {
                    waitCoordinates.add(new Coordinate(next.getX() - 1, next.getY()));
                }
                if (next.getY() > 0 && grid[next.getX()][next.getY() - 1] == '1') {
                    waitCoordinates.add(new Coordinate(next.getX(), next.getY() - 1));
                }
                grid[next.getX()][next.getY()] = '0';
            }
            numOfIslands ++;
        }
    }
}


public class Main {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
//        char[][] grid = {{'1'}, {'1'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(grid));
    }

}