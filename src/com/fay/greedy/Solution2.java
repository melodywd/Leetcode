package com.fay.greedy;

public class Solution2 {
    public boolean canJump(int[] nums) {
        // 跳跃的最远距离
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 到达不了 i 的位置，返回false
            if (i > max) return false;
            // 更新最大跳跃距离
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
