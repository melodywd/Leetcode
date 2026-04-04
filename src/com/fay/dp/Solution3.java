package com.fay.dp;

public class Solution3 {
    public int rob(int[] nums) {
        // 到当前房屋时偷窃的最大金额
        int sum = 0;
        // 记录前面两间房屋偷窃的最大金额
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(a + nums[i], b);
            // 更新状态
            a = b;
            b = sum;
        }
        return sum;
    }
}
