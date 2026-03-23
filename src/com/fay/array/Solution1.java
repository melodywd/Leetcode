package com.fay.array;

public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        // 记录连续子数组最大和
        int res = nums[0];
        // 动态规划变量 dp，记录当前元素结尾的连续子数组最大和
        int dp = 0;
        for (int num : nums) {
            dp = Math.max(dp + num, num);
            res = Math.max(res,dp);
        }
        return res;
    }
}
