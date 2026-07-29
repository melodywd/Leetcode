package com.fay.array;

import java.util.Scanner;

public class Solution3ACM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = rotate(nums,k);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        return nums;
    }
    public static void reverse(int[] nums, int start, int end) {
        while  (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
