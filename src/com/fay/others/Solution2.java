package com.fay.others;

public class Solution2 {
    public int majorityElement(int[] nums) {
        // 票数统计
        int count = 0;
        // 众数
        int x = 0;
        for (int num : nums) {
            // 重置众数
            if (count == 0) x = num;
            // 众数票数加1
            if (num == x) count += 1;
            // 非众数票数减1
            else count -= 1;
        }
        return x;
    }
}
