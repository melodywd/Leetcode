package com.fay.dp;

public class Solution4 {
    public int numSquares(int n) {
        // 定义状态数组 dp，dp[i]为表示整数i的平方数的最少个数
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            // 初始化状态为最大值
            dp[i] = i;
            for (int j = 0; j * j <= i; j++) {
                // 状态转移方程
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
