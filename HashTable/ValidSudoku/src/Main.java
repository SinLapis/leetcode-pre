public class Main {
    public static void main(String[] args) {
        char[][] b = new char[][]{{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        Solution s = new Solution();
        s.gridCheck(b);
    }
}

class Solution {
    boolean rowCheck(char[][] board) {
        for (char[] row : board) {
            boolean[] count = new boolean[10];
            for (char c : row) {
                if (c == '.') {
                    continue;
                }
                if (count[c - '0']) {
                    return false;
                } else {
                    count[c - '0'] = true;
                }
            }
        }
        return true;
    }

    boolean columnCheck(char[][] board) {
        for (int column = 0; column < board[0].length; column++) {
            boolean[] count = new boolean[10];
            for (char[] chars : board) {
                if (chars[column] == '.') {
                    continue;
                }
                if (count[chars[column] - '0']) {
                    return false;
                } else {
                    count[chars[column] - '0'] = true;
                }
            }
        }
        return true;
    }

    boolean gridCheck(char[][] board) {
        for (int x = 0; x < board.length; x += 3) {
            for (int y = 0; y < board[0].length; y += 3) {
                boolean[] count = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[x + i][y + j] == '.') {
                            continue;
                        }
                        if (count[board[x + i][y + j] - '0']) {
                            return false;
                        } else {
                            count[board[x + i][y + j] - '0'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return rowCheck(board) && columnCheck(board) && gridCheck(board);
    }
}
