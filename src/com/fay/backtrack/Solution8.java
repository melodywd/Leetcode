package com.fay.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution8 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // nxn 的棋盘
        char[][] board = new char[n][n];
        // 列数
        boolean[] col = new boolean[n];
        // 主对角线
        boolean[] d1 = new boolean[2*n - 1];
        // 副对角线
        boolean[] d2 = new boolean[2*n - 1];
        // 初始化棋盘
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board, col, d1, d2, ans);
        return ans;
    }

    public void dfs(int r, char[][] board, boolean[] col, boolean[] d1, boolean[] d2, List<List<String>> ans) {
        int n = col.length;
        // 递归边界
        if (r == n) {
            List<String> path = new ArrayList<>();
            for (char[] row : board) {
                path.add(new String(row));
            }
            ans.add(path);
            return;
        }
        // 遍历列
        for (int c = 0; c < n; c++) {
            if (!col[c] && !d1[r-c+n-1] && !d2[r+c]){
                // 放置皇后
                board[r][c] = 'Q';
                col[c] = d1[r+c] = d2[r-c+n-1] = true;
                // 递归下一行
                dfs(r+1,board, col, d1, d2, ans);
                // 回退
                board[r][c] = '.';
                col[c] = d1[r+c] = d2[r-c+n-1] = false;
            }
        }

    }
}
