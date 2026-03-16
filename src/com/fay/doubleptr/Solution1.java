package com.fay.doubleptr;

public class Solution1 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        // 定义左右两个指针和容器的容积
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r){
            if (height[l] < height[r]) {
                res = Math.max((r - l) * height[l],res);
                l++;
            }else {
                res = Math.max((r - l) * height[r],res);
                r--;
            }
        }
        return res;
    }
}
