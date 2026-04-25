package com.fay.graph;

public class Solution1 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    // 遍历岛屿周围
    public void dfs(char[][] grid, int i, int j) {
        // 递归边界————超过边界或者遇到水域
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        // 遍历过的岛屿置零
        grid[i][j] = '0';
        // 上下左右
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
