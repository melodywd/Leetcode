package com.fay.binarysearch;

public class Solution5 {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,1,2,3};
        int[] nums2 = {4,5,6,7,3};
        System.out.println(findMin(nums1));
        System.out.println(findMin(nums2));
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
                // 最小值为数组最后一个，直接返回防止索引越界
                return nums[mid];
            }
        }
        // 返回最小值
        return nums[left];
    }
}
