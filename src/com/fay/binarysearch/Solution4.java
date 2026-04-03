package com.fay.binarysearch;

public class Solution4 {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        // 先查找数组最小值的索引
        int i = findMin(nums);
        // 判断目标值在哪个区间，在区间内二分查找
        if (target > nums[n]) {
            return searchInRange(nums,0,i-1,target);
        }else {
            return searchInRange(nums,i,n,target);
        }
    }
    public static int findMin(int[] nums) {
        // 二分查找旋转排序数组的最小值，闭区间
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left)/2;
            // 中间值和数组末尾比较
            if (nums[mid] < nums[n]) {
                right = mid - 1;
            }else if (nums[mid] > nums[n]){
                left = mid + 1;
            }else {
                // 最小值为数组最后一个
                return n;
            }
        }
        // 返回最小值索引
        return left;
    }
    public static int searchInRange(int[] nums, int i, int j, int target) {
        int left = i;
        int right = j;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                // target 在左区间，所以[left, middle - 1]
                right = mid - 1;
            }else {
                // target 在右区间，所以[middle + 1, right]
                left = mid + 1;
            }
        }
        return -1;
    }
}
