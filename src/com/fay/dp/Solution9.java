package com.fay.dp;


public class Solution9 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 求数组元素和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果和为奇数，不能分割等和子集
        if (sum % 2 == 1) return false;
        // 两个子集的和为数组和的一半
        int target = sum / 2;
        // 状态数组dp[][]，dp[i][j]表示nums[0...i]是否存在若干元素和为j
        boolean[][] dp = new boolean[n][target+1];
        // 初始化状态
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                // 当前元素小于和时，选或不选二选一
                if (nums[i] <= j ) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else {
                    // 元素大于子集和时只能不选
                    dp[i][j] = dp[i-1][j];
                }
                if (dp[i][target]) return true;
            }
        }
        return false;
    }
}
