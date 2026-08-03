package com.fay.binarysearch;

import java.util.Scanner;

public class Solution4ACM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int n =  nums.length;
        int min = findMin(nums);
        if (target > nums[n-1]) {
           return searchInRange(nums, 0, min-1, target);
        }else {
            return searchInRange(nums, min, n-1, target);
        }

    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int  mid = left + (right - left) / 2;
            if (nums[mid] < nums[n-1]) {
                right = mid - 1;
            }else if (nums[mid] > nums[n-1]) {
                left = mid + 1;
            }else return n-1;
        }
        return left;
    }
    public static int searchInRange(int[] nums, int i, int j, int target) {
        int left = i;
        int right = j;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
