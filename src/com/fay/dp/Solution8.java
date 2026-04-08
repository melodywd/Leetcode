package com.fay.dp;

public class Solution8 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 状态数组dp，要考虑负数的影响，需要最大乘积和最小乘积来用于后续比较
        // dp1[i]表示以nums[i]结尾的子数组最大乘积，dp2[i]表示以nums[i]结尾的子数组最小乘积
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        // 初始化状态
        dp1[0] = dp2[0] = nums[0];
        // 结果变量
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = dp2[i] = nums[i];
            // 最小值可能为负数，乘以负数可能为最大值；最大值乘以负数可能为最小值
            dp1[i] = Math.max(Math.max(nums[i] * dp1[i-1],nums[i] * dp2[i-1]),dp1[i]);
            dp2[i] = Math.min(Math.min(nums[i] * dp1[i-1],nums[i] * dp2[i-1]),dp2[i]);

            res = Math.max(res,dp1[i]);
        }
        return res;
    }
}
