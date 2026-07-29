package com.fay.array;

import java.util.Scanner;

public class Solution4ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
       int n = nums.length;
       if (n == 0) return new int[0];
       int[] res = new int[n];
       res[0] = 1;
       for (int i = 1; i < n; i++) {
           res[i] = res[i-1] * nums[i-1];
       }
       int temp = 1;
       for (int i = n - 2; i >= 0; i--) {
           temp *= nums[i+1];
           res[i] *= temp;
       }
       return res;
    }
}
