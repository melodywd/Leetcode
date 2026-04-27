package com.fay.multidp;

public class Solution1 {
    public int uniquePaths(int m, int n) {
        // 多维动态规划
        // dp[i][j] 表示 到达(i,j)位置有多少种走法
        int[][] dp = new int[m][n];
        // 第一列初始化为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 第一行初始化为 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 状态更新
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
