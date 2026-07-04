package com.fay.greedy;

public class Solution3 {
    public int jump(int[] nums) {
        // 当前跳跃最远距离和下一步跳跃最远距离
        int cur = 0;
        int next = 0;
        // 步数
        int res = 0;
        // 遍历终点为 n - 2，走到 n - 1不用再走了
        for (int i = 0; i < nums.length - 1; i++) {
            // 每一步尽可能跳最远
            next = Math.max(next, i + nums[i]);
            // 走完开始下一步
            if (i == cur) {
                cur = next;
                res++;
            }
        }
        return res;
    }
}
