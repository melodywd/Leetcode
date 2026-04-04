package com.fay.binarysearch;

public class Solution3 {
    public int[] searchRange(int[] nums, int target){
        // 如果数组中没有目标值，返回{-1,-1}
        boolean flag = search(nums,target);
        if (!flag) {
            return new int[]{-1,-1};
        }
        int left = searchLeft(nums,target);
        int right = searchRight(nums,target);
        return new int[]{left,right};

    }
    // 二分查找左边界
    public static int searchLeft(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
    // 二分查找右边界
    public static int searchRight(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
    // 二分查找
    public static boolean search(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) {
                // target 在左区间，所以[left, middle - 1]
                right = mid - 1;
            }else {
                // target 在右区间，所以[middle + 1, right]
                left = mid + 1;
            }
        }
        return false;
    }
}
