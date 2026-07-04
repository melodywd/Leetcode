package com.fay.multidp;

public class Solution2 {
    public int minPathSum(int[][] grid) {
        // 多维动态规划
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] 表示 到达(i,j)位置最小路径和
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] += dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] += dp[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 状态转移
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
