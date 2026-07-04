package com.fay.others;

public class Solution3 {
    public void sortColors(int[] nums) {
        // 记录0和1插入位置
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            // 先用2覆盖
            int x = nums[i];
            nums[i] = 2;
            // 如果是0或1，前面插入1
            if (x <= 1) {
                nums[p1] = 1;
                p1++;
            }
            // 是0，前面再插个0
            if (x == 0) {
                nums[p0] = 0;
                p0++;
            }
        }
    }
}
