package com.fay.dp;

import java.util.Scanner;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int sum = 0;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            sum = Math.max(a + num, b);
            a = b;
            b = sum;
        }
        return sum;
    }
}
