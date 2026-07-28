package com.fay.doubleptr;

import java.util.Scanner;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int res = 0;
        int preMax = 0;
        int sufMax = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            preMax = Math.max(height[l], preMax);
            sufMax = Math.max(height[r], sufMax);
            if (preMax < sufMax) {
                res += preMax - height[l];
                l++;
            }else {
                res += sufMax - height[r];
                r--;
            }
        }
        return res;
    }
}
