package com.feng.dfs;

import java.util.Arrays;

/**
 * @author YiTian (HuangSuip sp.huang@tuya.com)
 */
public class Q79 {
    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABFDEE";
        //System.out.println(new Solution79_2().exist(board, word));
        //System.out.println(new Solution79().exist(board, word));
        System.out.println(new Solution79_3().exist(board, word));

    }
}

class Solution79_3 {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}


class Solution79_2 {

    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        dfs(board, 0, 0, word, 0, flag);
        for (boolean[] booleans : flag) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println();
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int index, boolean[][] flag) {
        //System.out.println(x + " " + y);
        if (index >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        if (board[x][y] == word.charAt(index)) {
            flag[x][y] = true;
        }
        dfs(board, x + 1, y, word, index + 1, flag);
        for (boolean[] booleans : flag) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println();
        dfs(board, x - 1, y, word, index + 1, flag);
        for (boolean[] booleans : flag) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println();
        dfs(board, x, y + 1, word, index + 1, flag);
        for (boolean[] booleans : flag) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println();
        dfs(board, x, y - 1, word, index + 1, flag);
        for (boolean[] booleans : flag) {
            System.out.println(Arrays.toString(booleans));
        }
        System.out.println();
        return false;
    }


}

class Solution79 {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
