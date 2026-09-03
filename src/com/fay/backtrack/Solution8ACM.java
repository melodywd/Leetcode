package com.fay.backtrack;
import java.util.*;

public class Solution8ACM {
    public static void main(String[] args) {

    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2*n - 1];
        boolean[] d2 = new boolean[2*n - 1] ;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board, col, d1, d2, ans);
        return ans;
    }

    public static void dfs(int r, char[][] board, boolean[] col, boolean[] d1, boolean[] d2, List<List<String>> ans) {
        if (r == col.length) {
            List<String> path = new ArrayList<>();
            for (char[] row : board) {
                path.add(new String(row));
            }
            ans.add(path);
            return;
        }

    }
}
