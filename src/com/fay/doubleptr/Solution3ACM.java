package com.fay.doubleptr;

public class Solution3ACM {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int res = 0;
        // 双指针
        int left = 0;
        int right = height.length - 1;
        // 前缀和后缀的最大值，随着指针移动而更新
        int preMax = 0;
        int sufMax = 0;

        while (left < right) {
            // 更新前缀和后缀最大值
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            // 判断左右最小值，收集雨水
            if (preMax < sufMax) {
                res += preMax - height[left];
                left++;
            }else {
                res += sufMax - height[right];
                right--;
            }
        }
        return res;
    }
}
