package com.fay.binarysearch;

import java.util.Scanner;

public class Solution3ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = searchRange(nums,target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
    public static int[] searchRange(int[] nums, int target){
        // 如果数组中没有目标值，返回{-1,-1}
        boolean flag = search(nums,target);
        if (!flag) {
            return new int[]{-1,-1};
        }
        int left = searchLeft(nums,target);
        int right = searchRight(nums,target);
        return new int[]{left,right};

    }

    public static int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    public static int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid - 1;
            }else  {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) {
                l = mid + 1;
            }else  {
                r = mid - 1;
            }
        }
        return false;
    }
}
