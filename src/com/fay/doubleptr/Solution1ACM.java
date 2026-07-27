package com.fay.doubleptr;

import java.util.Scanner;

public class Solution1ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
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
