package com.fay.dp;
import java.util.Scanner;

public class Solution8ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fmin = new int[n];
        int[] fmax = new int[n];
        fmin[0] = fmax[0] = nums[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            fmin[i] = fmax[i] = nums[i];

            fmax[i] = Math.max(Math.max(fmax[i-1] * nums[i], fmin[i-1] * nums[i]),nums[i]);
            fmin[i] = Math.min(Math.min(fmin[i-1] * nums[i], fmax[i-1] * nums[i]),nums[i]);
            res = Math.max(res, fmax[i]);
        }
        return res;
    }
}
