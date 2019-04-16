import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    @Override
    public boolean equals(Object obj) {
        try {
            return this.x == ((Coordinate) obj).x && this.y == ((Coordinate) obj).y;
        } catch (ClassCastException cce) {
            return super.equals(obj);
        }
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
        List<Coordinate> visitedCoordinates = new ArrayList<>();
        Stack<Coordinate> currentRoute = new Stack<>();
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
            currentRoute.push(start);
            visitedCoordinates.add(start);
            while (true) {
                Coordinate next = currentRoute.peek();
                visitedCoordinates.add(next);
                // 2. find next '1'
                Coordinate left = new Coordinate(next.getX() - 1, next.getY());
                Coordinate right = new Coordinate(next.getX() + 1, next.getY());
                Coordinate up = new Coordinate(next.getX(), next.getY() - 1);
                Coordinate down = new Coordinate(next.getX(), next.getY() + 1);
                if (next.getX() < width - 1 && grid[next.getX() + 1][next.getY()] == '1' && !visitedCoordinates.contains(right)) {
                    currentRoute.push(right);
                } else if (next.getY() < height - 1 && grid[next.getX()][next.getY() + 1] == '1' && !visitedCoordinates.contains(down)) {
                    currentRoute.push(down);
                } else if (next.getX() > 0 && grid[next.getX() - 1][next.getY()] == '1' && !visitedCoordinates.contains(left)) {
                    currentRoute.push(left);
                } else if (next.getY() > 0 && grid[next.getX()][next.getY() - 1] == '1' && !visitedCoordinates.contains(up)) {
                    currentRoute.push(up);
                } else {
                    // 3. pop to back
                    grid[next.getX()][next.getY()] = '0';
                    currentRoute.pop();
                    // 4. if back to start then break
                    if (start.getY() == next.getY() && start.getX() == next.getX()) {
                        numOfIslands++;
                        break;
                    }
                }
            }
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
