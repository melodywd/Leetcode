package com.fay.binarysearch;

public class Solution1 {
    public int searchInsert(int[] nums, int target) {
        // 定义左右两个边界，区间是左闭右闭
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        // 当left==right，区间[left, right]有效
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                // target 在左区间，所以[left, middle - 1]
                right = mid - 1;
            }else if (nums[mid] < target) {
                // target 在右区间，所以[middle + 1, right]
                left = mid + 1;
            }else {
                return mid;
            }
        }
        // 结束循环，返回插入索引
        return left;
    }
}
