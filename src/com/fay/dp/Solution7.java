package com.fay.dp;

public class Solution7 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int res = 0;
        // 状态数组dp，dp[i]表示以nums[i]结尾的最长子序列长度
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化状态
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
