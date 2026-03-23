package com.fay.array;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return new int[0];
        }
        // 结果数组
        int[] ans = new int[n];
        ans[0] = 1;
        // 计算除自身以外左边所有乘积
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int temp = 1;
        for (int i = n - 2; i >= 0; i--) {
            // 计算除自身以外右边所有乘积
            temp = temp * nums[i + 1];
            // 左右两边相乘
            ans[i] = ans[i] * temp;
        }
        return ans;
    }
}
