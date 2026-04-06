package com.fay.dp;

public class Solution5 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        // 定义状态数组 dp，dp[i]为凑成金额 i 的最少硬币个数
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 初始状态为最大值，便于后面比较
            dp[i] = amount + 1;
            for (int j : coins) {
                if (i - j >= 0) {
                    // 状态转移方程
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
