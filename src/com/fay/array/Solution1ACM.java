package com.fay.array;

import java.util.Scanner;

public class Solution1ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
       int res = nums[0];
       int dp = 0;
        for (int num : nums) {
            dp = Math.max(dp + num, num);
            res = Math.max(res, dp);
        }
       return res;
    }
}
